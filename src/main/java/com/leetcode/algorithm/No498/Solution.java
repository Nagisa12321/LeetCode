package com.leetcode.algorithm.No498;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 15:29
 */
public class Solution {
	public int[] findDiagonalOrder(int[][] matrix) {
		int len_i = matrix.length;
		int len_j = matrix[0].length;
		int[] result = new int[len_i * len_j];
		track(0, 0, 0, len_i, len_j, matrix, result, 1);
		return result;
	}


	// state:
	// 1: right up
	// -1. left down
	public void track(int i, int j, int idx, int len_i, int len_j, int[][] matrix, int[] result, int state) {
		if (idx >= result.length) return;
		if (i < 0) {
			if (j == len_j) track(1, j - 1, idx, len_i, len_j, matrix, result, -state);
			else track(0, j, idx, len_i, len_j, matrix, result, -state);
			return;
		} else if (j == len_j) {
			track(i + 2, j - 1, idx, len_i, len_j, matrix, result, -state);
			return;
		} else if (j < 0) {
			if (i == len_i) track(i - 1, j + 2, idx, len_i, len_j, matrix, result, -state);
			else track(i, 0, idx, len_i, len_j, matrix, result, -state);
			return;
		} else if (i == len_i) {
			track(i - 1, j + 2, idx, len_i, len_j, matrix, result, -state);
			return;
		}

		result[idx] = matrix[i][j];
		if (state == 1) track(i - 1, j + 1, idx + 1, len_i, len_j, matrix, result, state);
		else track(i + 1, j - 1, idx + 1, len_i, len_j, matrix, result, state);
	}
}