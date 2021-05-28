package com.leetcode.queueorstack.queue.No1;

import org.junit.Test;

public class MyCircularQueueTest {
	@Test
	public void test1() {
		MyCircularQueue queue = new MyCircularQueue(2);

		System.out.println(queue.enQueue(1));
		System.out.println(queue.enQueue(2));

		System.out.println(queue.deQueue());

		System.out.println(queue.enQueue(3));

		System.out.println(queue.deQueue());

		System.out.println(queue.enQueue(3));

		System.out.println(queue.deQueue());

		System.out.println(queue.enQueue(3));

		System.out.println(queue.deQueue());

		System.out.println(queue.Front());
	}
}