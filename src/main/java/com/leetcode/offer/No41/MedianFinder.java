package com.leetcode.offer.No41;

import java.util.PriorityQueue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/14 22:47
 */
public class MedianFinder {
	private PriorityQueue<Integer> leftQueue;
	private PriorityQueue<Integer> rightQueue;

	/**
	 * initialize your data structure here.
	 */
	public MedianFinder() {
		this.leftQueue = new PriorityQueue<>((x, y) -> y - x);
		this.rightQueue = new PriorityQueue<>();
	}

	public void addNum(int num) {
		int left = leftQueue.peek() == null ? 0 : leftQueue.peek();
		int right = rightQueue.peek() == null ? 0 : rightQueue.peek();

		int mid = (left + right) / 2;
		if (num <= mid) leftQueue.offer(num);
		else rightQueue.offer(num);
	}

	public double findMedian() {
		int tmp = leftQueue.size() - rightQueue.size();
		if (tmp > 0) {
			for (int i = 0; i < tmp / 2; i++)
				rightQueue.offer(leftQueue.poll());
		} else if (tmp < 0)
            for (int i = 0; i < -tmp / 2; i++)
                leftQueue.offer(rightQueue.poll());
        if (leftQueue.size() == rightQueue.size()) { return (double) (leftQueue.peek() + rightQueue.peek()) / 2; }
        else if (leftQueue.size() > rightQueue.size()) { return leftQueue.peek(); }
        else { return rightQueue.peek(); }
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */