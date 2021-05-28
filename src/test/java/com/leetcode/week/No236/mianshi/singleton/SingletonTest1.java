package com.leetcode.week.No236.mianshi.singleton;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingletonTest1 {
	private static Lock lock = new ReentrantLock();
	private static Semaphore A = new Semaphore(0);
	private static Semaphore B = new Semaphore(0);
	private static Semaphore C = new Semaphore(0);
	private static Semaphore empty = new Semaphore(1);

	private static int count = 0;

	static class PrintThread implements Runnable {
		private Semaphore semaphore;
		private Semaphore finish;
		private int num;

		public PrintThread(Semaphore Semaphore, Semaphore finish) {
			this.semaphore = Semaphore;
			this.finish = finish;
		}

		@Override
		public void run() {
			while (true) {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName() + ": " + num);
					finish.release();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		public void setNum(int num) {
			this.num = num;
		}
	}


	public static void main(String[] args) throws InterruptedException {
		PrintThread r1 = new PrintThread(A, empty);
		PrintThread r2 = new PrintThread(B, empty);
		PrintThread r3 = new PrintThread(C, empty);
		new Thread(r1).start();
		new Thread(r2).start();
		new Thread(r3).start();
		for (int i = 1; i <= 100; i++) {
			switch (i % 3) {
				case 1:
					empty.acquire();
					A.release();
					r1.setNum(i);
					break;
				case 2:
					empty.acquire();
					B.release();
					r2.setNum(i);
					break;
				case 0:
					empty.acquire();
					C.release();
					r3.setNum(i);
					break;
			}
		}
	}
}