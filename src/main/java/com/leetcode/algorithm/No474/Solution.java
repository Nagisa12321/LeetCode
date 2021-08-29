package com.leetcode.algorithm.No474;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/13 17:11
 */
public class Solution {
	public int findMaxForm(String[] strs, int m, int n) {
		int len = strs.length;
		int[] one = new int[len];
		int[] zero = new int[len];

		for (int i = 0; i < len; i++) {
			char[] chs = strs[i].toCharArray();
			for (char ch : chs) {
				if (ch == '1')
					one[i]++;
				else
					zero[i]++;
			}
		}

		int[][][] dp = new int[len][m][n];
		dp[0][0][0] = 1;
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++) {
					if (j < zero[i] || k < one[i]) {
						dp[i][j][k] = dp[i - 1][j][k];
					} else {
						dp[i][j][k] = Math.max(dp[i - 1][j][k],
								dp[i - 1][j - zero[i]][k - one[i]] + 1);
					}
				}
			}
		}
		return dp[len - 1][m - 1][n - 1];
	}
}