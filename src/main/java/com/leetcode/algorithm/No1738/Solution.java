package com.leetcode.algorithm.No1738;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/19 15:20
 */
public class Solution {
	public int kthLargestValue(int[][] matrix, int k) {
		int[] res = new int[matrix.length * matrix[0].length];
		int idx = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] ^= (i > 0 ? matrix[i - 1][j] : 0) ^
						(j > 0 ? matrix[i][j - 1] : 0) ^
						(i > 0 && j > 0 ? matrix[i - 1][j - 1] : 0);
				res[idx++] = matrix[i][j];
			}
		}
		int matrixSize = res.length;
		buildHeap(res, matrixSize);
		for (int i = 0; i < k - 1; i++) {
			swap(res, 0, matrixSize--);
			heapify(res, 0, matrixSize);
		}
		return res[0];
	}
	void buildHeap(int[] arr, int n) {
		int idx = (n - 1) / 2;
		while (idx >= 0) {
			heapify(arr, idx--, n);
		}
	}

	void heapify(int[] arr, int i, int n) {
		if (i >= n) return;

		int c1 = i * 2 + 1;
		int c2 = i * 2 + 2;
		int max = i;
		if (c1 < n && arr[c1] > arr[max]) { max = c1; }
		if (c2 < n && arr[c2] > arr[max]) { max = c2; }

		if (max != i) {
			swap(arr, max, i);
			heapify(arr, max, n);
		}
	}

	void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}