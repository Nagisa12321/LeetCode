package com.leetcode.algorithm.No45;

import java.util.PriorityQueue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/2 21:01
 */
public class Solution {
	public int jump(int[] nums) {
		if (nums.length == 1) return 0;
		int[] helper = new int[nums.length];
		for (int i = 1; i < nums.length; i++) {
			helper[i] = nums.length;
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j <= nums[i]; j++) {
				if (i + j >= nums.length - 1) return helper[i] + 1;
				else if (helper[i + j] > helper[i] + 1) {
					helper[i + j] = helper[i] + 1;
				}
			}
		}
		return -1;
	}
}