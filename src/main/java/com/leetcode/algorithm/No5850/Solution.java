package com.leetcode.algorithm.No5850;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/22 16:32
 */
public class Solution {
	public int findGCD(int[] nums) {
		int min = nums[0];
		int max = nums[0];

		for (int i = 0; i < nums.length; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}

		for (int i = min; i > 0; --i) {
			if (max % i == 0 && min % i == 0)
				return i;
		}
		return 1;
	}
}