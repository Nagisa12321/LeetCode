package com.leetcode.algorithm.No1137;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/8 14:45
 */
public class Solution {
	public int tribonacci(int n) {
		int[] dp = new int[n < 2 ? 3 : n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
		}
		return dp[n];
	}
}