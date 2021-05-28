package com.leetcode.algorithm.No363;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/22 14:09
 */
public class Solution2 {
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int len_i = matrix.length;
		int len_j = matrix[0].length;
		int max = Integer.MIN_VALUE;
		for (int m = 0; m < len_i; m++) {

			int[] colSum = new int[len_j];

			// calculate the col sum.
			for (int i = m; i < len_i; i++) {
				for (int j = 0; j < len_j; j++) {
					if (i == 0) colSum[j] = matrix[i][j];
					else colSum[j] = matrix[i][j] + colSum[j];
				}

				for (int x = 0; x < len_j; x++) {
					int sum = 0;
					for (int y = x; y < len_j; y++) {
						sum += colSum[y];
						if (sum <= k) max = Math.max(sum, max);
						if (sum == k) return k;
					}
				}
			}
		}

		return max;
	}
}