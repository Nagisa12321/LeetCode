package com.leetcode.advanced.treeorfigure.No8;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/27 11:55
 */
public class Solution {
	private int max = 0;

	public int longestIncreasingPath(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				dfs(matrix, i, j, 1);
			}
		}
		return max;
	}

	public void dfs(int[][] matrix, int i, int j, int count) {
		max = Math.max(max, count);
		int len_i = matrix.length;
		int len_j = matrix[0].length;
		int cur = matrix[i][j];
		if (i - 1 >= 0 && matrix[i - 1][j] > cur) dfs(matrix, i - 1, j, count + 1);
		if (i + 1 < len_i && matrix[i + 1][j] > cur) dfs(matrix, i + 1, j, count + 1);
		if (j - 1 >= 0 && matrix[i][j - 1] > cur) dfs(matrix, i, j - 1, count + 1);
		if (j + 1 < len_j && matrix[i][j + 1] > cur) dfs(matrix, i, j + 1, count + 1);
	}
}