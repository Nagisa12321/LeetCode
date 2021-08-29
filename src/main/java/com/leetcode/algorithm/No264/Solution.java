package com.leetcode.algorithm.No264;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/13 14:05
 */
public class Solution {
	public int nthUglyNumber(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			long min = Integer.MAX_VALUE;
			for (int j = i - 1; j >= 1; j--) {
				if (dp[j] * 2 > dp[i - 1]) min = Math.min(min, (long) dp[j] * 2);
				if (dp[j] * 3 > dp[i - 1]) min = Math.min(min, (long) dp[j] * 3);
				if (dp[j] * 5 > dp[i - 1]) min = Math.min(min, (long) dp[j] * 5);
			}
			dp[i] = Math.toIntExact(min);
		}

		return dp[n];
	}
}