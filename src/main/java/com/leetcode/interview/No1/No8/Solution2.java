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
		// ������һ�е�һ��, �жϵ�һ�е�һ���Ƿ�Ӧ������
		// �б�־: [0, 0] == 0 ?
		// �б�־: col ?
		boolean col = false;
		// Ӧ�����ж���
		for (int[] ints : matrix) {
			if (ints[0] == 0) {
				col = true;
				break;
			}
		}

		// �ж���
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

		// ��������
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

		// �����һ�е�һ��

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