package com.leetcode.algorithm.No213;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/15 9:13
 */
public class Solution {
	public int rob(int[] nums) {
		int len = nums.length;
		if (len == 0) return 0;
		else if (len == 1) return nums[0];
		int[][] dp = new int[len][2];

		dp[0][0] = nums[0];
		dp[0][1] = 0;
		dp[1][0] = Math.max(nums[0], nums[1]);
		dp[1][1] = nums[1];


		for (int i = 2; i < len; i++) {
			if (i == len - 1)
				dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + nums[i] - nums[0]);
			else
				dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + nums[i]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + nums[i]);
		}

		return Math.max(dp[len - 1][0], dp[len - 1][1]);
	}
}