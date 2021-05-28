package com.leetcode.interview.No1.No8;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 14:53
 */
public class Solution2 {
	public void setZeroes(int[][] matrix) {
		int len_i = matrix.length;
		int len_j = matrix[0].length;
		// 遍历第一行第一列, 判断第一行第一列是否应该清零
		// 行标志: [0, 0] == 0 ?
		// 列标志: col ?
		boolean col = false;
		// 应该先判断列
		for (int[] ints : matrix) {
			if (ints[0] == 0) {
				col = true;
				break;
			}
		}

		// 判断行
		for (int j = 0; j < len_j; j++) {
			if (matrix[0][j] == 0) {
				matrix[0][0] = 0;
				break;
			}
		}

		for (int i = 1; i < len_i; i++) {
			for (int j = 1; j < len_j; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// 清理行列
		for (int j = 1; j < len_j; j++) {
			if (matrix[0][j] == 0) {
				for (int i = 1; i < len_i; i++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int i = 1; i < len_i; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 1; j < len_j; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		// 清理第一行第一列

		if (matrix[0][0] == 0) {
			for (int j = 1; j < len_j; j++) {
				matrix[0][j] = 0;
			}
		}

		if (col) {
			for (int i = 0; i < len_i; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}