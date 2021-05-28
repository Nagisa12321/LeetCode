package com.leetcode.interview.No1.No8;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 14:45
 */
public class Solution {
	private static final int NUM = 123456;

	public void setZeroes(int[][] matrix) {
		int len_i = matrix.length;
		int len_j = matrix[0].length;

		// int[][] help = new int[len_i][len_j];
		for (int i = 0; i < len_i; i++) {
			for (int j = 0; j < len_j; j++) {
				if (matrix[i][j] == 0)
					matrix[i][j] = NUM;
			}
		}

		for (int i = 0; i < len_i; i++) {
			for (int j = 0; j < len_j; j++) {
				if (matrix[i][j] == NUM) {
					// 清空行
					for (int k = 0; k < len_j; k++) {
						if (matrix[i][k] != NUM)
							matrix[i][k] = 0;
					}

					// 清空列
					for (int k = 0; k < len_i; k++) {
						if (matrix[k][j] != NUM)
							matrix[k][j] = 0;
					}
				}
			}
		}
		for (int i = 0; i < len_i; i++) {
			for (int j = 0; j < len_j; j++) {
				if (matrix[i][j] == NUM) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}