package com.leetcode.advanced.treeorfigure.No8;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/27 12:06
 */
public class Solution2 extends Solution {

	int[][] dp;

	public int longestIncreasingPath(int[][] matrix) {
		dp = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				dp[i][j] = -1;
		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				max = Math.max(max, longestIncreasingPath(matrix, i, j));
			}
		}
		return max + 1;
	}

	// 从该坐标出发还能走几格
	public int longestIncreasingPath(int[][] matrix, int i, int j) {
		int max = 0;
		int len_i = matrix.length;
		int len_j = matrix[0].length;
		int cur = matrix[i][j];

		if (i - 1 >= 0 && matrix[i - 1][j] > cur) {
			if (dp[i - 1][j] != -1) max = Math.max(max, dp[i - 1][j] + 1);
			else max = Math.max(max, longestIncreasingPath(matrix, i - 1, j) + 1);
		}
		if (i + 1 < len_i && matrix[i + 1][j] > cur) {
			if (dp[i + 1][j] != -1) max = Math.max(max, dp[i + 1][j] + 1);
			else max = Math.max(max, longestIncreasingPath(matrix, i + 1, j) + 1);
		}
		if (j - 1 >= 0 && matrix[i][j - 1] > cur) {
			if (dp[i][j - 1] != -1) max = Math.max(max, dp[i][j - 1] + 1);
			else max = Math.max(max, longestIncreasingPath(matrix, i, j - 1) + 1);
		}
		if (j + 1 < len_j && matrix[i][j + 1] > cur) {
			if (dp[i][j + 1] != -1) max = Math.max(max, dp[i][j + 1] + 1);
			else max = Math.max(max, longestIncreasingPath(matrix, i, j + 1) + 1);
		}

		dp[i][j] = max;
		return max;
	}

}
