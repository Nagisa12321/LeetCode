package com.leetcode.week.No236.mianshi.singleton;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/9 9:43
 */
public class Singleton {

	private Singleton() {}

	private volatile static Singleton singleton = null;

	public static Singleton getInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}

	public void test() { System.out.println(Thread.currentThread().getName()); }
}
