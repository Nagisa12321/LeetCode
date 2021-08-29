package com.leetcode.interview.No17.No14;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/18 12:00
 */
public class Solution {
	public int[] smallestK(int[] arr, int k) {
		int[] result = new int[k];
		int arrSize = arr.length;
		heapSort(arr, arrSize);
		for (int i = 0; i < k; i++) {
			result[i] = arr[0];
			swap(arr, 0, arrSize-- - 1);
			heapify(arr, 0, arrSize);
		}

		return result;
	}

	void heapSort(int[] arr, int n) {
		int i = (n - 1) / 2;
		while (i >= 0) {
			heapify(arr, i--, n);
		}
	}

	void heapify(int[] arr, int i, int n) {
		if (i >= n) return;

		int c1 = i * 2 + 1;
		int c2 = i * 2 + 2;

		int min = i;
		if (c1 < n && arr[c1] < arr[min]) min = c1;
		if (c2 < n && arr[c2] < arr[min]) min = c2;

		if (i != min) {
			swap(arr, i, min);
			heapify(arr, min, n);
		}
	}

	void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}