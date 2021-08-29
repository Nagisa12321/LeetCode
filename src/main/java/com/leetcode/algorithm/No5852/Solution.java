package com.leetcode.algorithm.No5852;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/22 16:50
 */
public class Solution {
	public int minimizeTheDifference(int[][] mat, int target) {
		boolean[][] dp = new boolean[mat.length][5051];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (i == 0) {
					dp[i][mat[i][j]] = true;
					continue;
				}
				for (int k = 0; k < 5050; k++) {
					if (dp[i - 1][k] && k + mat[i][j] <= 5050) {
						dp[i][k + mat[i][j]] = true;
					}
				}
			}
		}

		int len = mat.length;
		int left = target, right = target;
		while (true) {
			if (in(left))
				if (dp[len - 1][left])
					return Math.abs(target - left);
			if (in(right))
				if (dp[len - 1][right])
					return Math.abs(target - right);
				left--;
				right++;
		}
	}

	private boolean in(int idx) {
		return idx >= 0 && idx <= 5050;
	}
}