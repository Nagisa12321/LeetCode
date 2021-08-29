package com.leetcode.week.No236.mianshi.singleton;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingletonTest {
	private static Lock lock = new ReentrantLock();
	private static Condition A = lock.newCondition();
	private static Condition B = lock.newCondition();
	private static Condition C = lock.newCondition();

	private static int count = 0;

	static class ThreadA extends Thread {
		@Override
		public void run() {
			lock.lock();
			try {
				while (true) {
					while (count % 3 != 0) {
						A.await();
					}
					if (count > 100) break;
					System.out.println(Thread.currentThread().getName() + ": " + count++);
					B.signal();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}

		}
	}

	static class ThreadB extends Thread {
		@Override
		public void run() {
			lock.lock();
			try {
				while (true) {
					while (count % 3 != 1) {
						B.await();
					}
					if (count > 100) break;

					System.out.println(Thread.currentThread().getName() + ": " + count++);
					C.signal();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

	static class ThreadC extends Thread {
		@Override
		public void run() {
			lock.lock();
			try {
				while (true) {
					while (count % 3 != 2) {
						C.await();
					}
					if (count > 100) break;

					System.out.println(Thread.currentThread().getName() + ": " + count++);
					A.signal();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		new ThreadA().start();
		new ThreadB().start();
		new ThreadC().start();
	}
}