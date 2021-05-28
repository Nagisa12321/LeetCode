package com.leetcode.queueorstack.queue.No1;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/2 10:21
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
public class MyCircularQueue {

	private final int MAX_SIZE;
	private final int[] buffer;
	private int left;
	private int right;

	public MyCircularQueue(int k) {
		MAX_SIZE = k + 1;
		buffer = new int[MAX_SIZE];
		left = 0;
		right = 0;
	}

	public boolean enQueue(int value) {
		if (isFull()) return false;

		buffer[right] = value;
		right = (right + 1) % MAX_SIZE;
		return true;
	}

	public boolean deQueue() {
		if (isEmpty()) return false;

		left = (left + 1) % MAX_SIZE;
		return true;
	}

	public int Front() {
		if (isEmpty()) return -1;

		return buffer[left];
	}

	public int Rear() {
		if (isEmpty()) return -1;

		return right == 0 ? buffer[MAX_SIZE - 1] : buffer[right - 1];

	}

	public boolean isEmpty() {
		return left == right;
	}

	public boolean isFull() {
		return (right + 1) % MAX_SIZE == left;
	}
}

