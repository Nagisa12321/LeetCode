package com.leetcode.algorithm.No377;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/24 8:54
 */
public class Solution2 {
	public int combinationSum4(int[] nums, int target) {
		// dp[i]: 目标和为i的组合总数
		int[] dp = new int[target + 1];
		dp[0] = 1;

		for (int i = 1; i <= target; i++) {
			for (int num : nums) {
				if (num <= i) {
					dp[i] += dp[i - num];
				}
			}
		}

		return dp[target];
	}
}