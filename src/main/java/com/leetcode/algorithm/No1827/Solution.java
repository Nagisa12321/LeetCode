package com.leetcode.algorithm.No1827;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/21 13:48
 */
public class Solution {
	public int minOperations(int[] nums) {
		int times = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1])
				continue;
			times += nums[i - 1] - nums[i] + 1;
			nums[i] = nums[i - 1] + 1;
		}
		return times;
	}
}