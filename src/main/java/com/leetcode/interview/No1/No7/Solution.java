package com.leetcode.interview.No1.No7;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 14:38
 */
public class Solution {
	public void rotate(int[][] matrix) {
		int len = matrix.length;

		// swap matrix[i][j], matrix[len_i - i - 1][j]
		for (int j = 0; j < len; j++) {
			for (int i = 0; i < len / 2; i++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[len - i - 1][j];
				matrix[len - i - 1][j] = tmp;
			}
		}

		// swap matrix[i][j], matrix[j][i]
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}
	}
}