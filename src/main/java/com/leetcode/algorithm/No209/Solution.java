package com.leetcode.algorithm.No209;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/14 14:52
 */
public class Solution {
	public int minSubArrayLen(int target, int[] nums) {
		int len = nums.length;
		if (len == 0) return 0;

		int left = 0, right = 0;
		int min = len;
		int sum = nums[0];
		while (sum < target && right < len - 1) {
			right++;
			sum += nums[right];
		}
		if (sum < target) return 0;

		while (true) {
			if (sum >= target) {
				min = Math.min(right - left + 1, min);
				sum -= nums[left];
				left++;
			} else {
				right++;
				if (right == len) break;
				sum += nums[right];
			}
		}
		// min = Math.min(right - left + 1, min);

		return min;
	}
}