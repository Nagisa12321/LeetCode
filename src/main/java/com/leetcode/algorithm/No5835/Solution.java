package com.leetcode.algorithm.No5835;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/22 10:33
 */
public class Solution {
	public long maxMatrixSum(int[][] matrix) {
		int min = Integer.MAX_VALUE;
		long sum = 0;
		int p = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] < 0)
					p++;
				int tmp = Math.abs(matrix[i][j]);
				sum += tmp;
				min = Math.min(min, tmp);
			}
		}
		if (p % 2 != 0)
			sum -= 2L * min;
		return sum;
	}
}
