package com.leetcode.algorithm.No53;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/14 11:17
 */
public class Solution {
	public int maxSubArray(int[] nums) {
		int len = nums.length;

		// dp[i] - 以下标i结尾的最大和
		int[] dp = new int[len];
		dp[0] = nums[0];
		int max = nums[0];

		for (int i = 1; i < len; i++) {
			dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
			max = Math.max(max, dp[i]);
		}

		return max;
	}
}