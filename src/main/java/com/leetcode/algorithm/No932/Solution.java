package com.leetcode.algorithm.No932;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/25 9:52
 */
public class Solution {
	public int[] beautifulArray(int n) {
		int[][] dp = new int[n < 2 ? 3 : n + 1][];
		dp[1] = new int[]{1};
		dp[2] = new int[]{1, 2};
		for (int i = 3; i <= n; i++) {
			int ridx = i / 2;
			int[] right = dp[ridx];
			int[] left = dp[i - ridx];

			int idx = 0;
			dp[i] = new int[i];
			for (int k : left) {
				dp[i][idx++] = k * 2 - 1;
			}
			for (int k : right) {
				dp[i][idx++] = k * 2;
			}
		}
		return dp[n];
	}
}