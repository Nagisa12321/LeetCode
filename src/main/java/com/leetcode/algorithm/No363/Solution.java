package com.leetcode.algorithm.No363;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/22 14:08
 */
public class Solution {
	// dp + ×´Ì¬Ñ¹Ëõ + Ç°×ººÍ
	private int[][] dp;

	public int sumRegion(int row1, int col1, int row2, int col2) {
		return dp[row2][col2] -
				(col1 == 0 ? 0 : dp[row2][col1 - 1]) -
				(row1 == 0 ? 0 : dp[row1 - 1][col2]) +
				(row1 == 0 || col1 == 0 ? 0 : dp[row1 - 1][col1 - 1]);
	}

	public int maxSumSubmatrix(int[][] matrix, int k) {
		int len_i = matrix.length;
		int len_j = matrix[0].length;

		dp = new int[len_i][len_j];
		for (int i = 0; i < len_i; i++) {
			for (int j = 0; j < len_j; j++) {
				dp[i][j] = (i == 0 ? 0 : dp[i - 1][j]) +
						(j == 0 ? 0 : dp[i][j - 1]) -
						(i == 0 || j == 0 ? 0 : dp[i - 1][j - 1]) +
						matrix[i][j];
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len_i; i++) {
			for (int j = 0; j < len_j; j++) {
				for (int m = i; m < len_i; m++) {
					for (int l = j; l < len_j; l++) {
						int sum = sumRegion(i, j, m, l);
						if (sum <= k) {
							max = Math.max(sum, max);
						}
					}
				}
			}
		}
		return max;
	}
}