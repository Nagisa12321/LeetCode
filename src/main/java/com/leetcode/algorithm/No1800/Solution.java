package com.leetcode.algorithm.No1800;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/5 1:28
 */
public class Solution {
	public int maxAscendingSum(int[] nums) {
		int left = 0, right = 0, max = nums[0];

		while (true) {
			int now = nums[left];
			while (right != nums.length - 1 && nums[right + 1] > nums[right]) {
				right++;
				now += nums[right];
			}

			max = Math.max(now, max);
			if (right == nums.length - 1) break;
			left = ++right;
		}

		return max;
	}
}