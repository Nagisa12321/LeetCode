package com.leetcode.binarysearchtree.No3.No1;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 10:10
 */
public class KthLargest {
	private final PriorityQueue<Integer> queue;
	private final int k;

	public KthLargest(int k, int[] nums) {
		this.k = k;
		queue = new PriorityQueue<>();
		for (int num : nums)
			add(num);
	}

	public int add(int val) {
		queue.add(val);
		if (queue.size() > k)
			queue.poll();

		return queue.peek();
	}
}


/*
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */