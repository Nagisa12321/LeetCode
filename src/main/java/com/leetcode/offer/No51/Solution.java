package com.leetcode.offer.No51;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/16 15:32
 */
public class Solution {
	private int change = 0;

	// 对数组进行归并排序, 统计交换次数
	public int reversePairs(int[] nums) {
		mergeSort(nums);
		return change;
	}

	public void mergeSort(int[] arr) {
		mergeSort(arr, new int[arr.length], 0, arr.length - 1);
	}

	public void mergeSort(int[] arr, int[] aux, int lo, int hi) {
		if (lo >= hi) return;

		int mid = lo + (hi - lo) / 2;
		mergeSort(arr, aux, lo, mid);
		mergeSort(arr, aux, mid + 1, hi);

		merge(arr, aux, lo, mid, hi);
	}

	//  l        m           h
	// [1, 4, 7, 9, 2, 5, 6, 8]
	//  i           j
	public void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
		// return
		if (arr[mid] <= arr[mid + 1]) return;

		// copy
		for (int k = lo; k <= hi; k++) {
			aux[k] = arr[k];
		}

		// merge
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				arr[k] = aux[j++];

			else if (j > hi) {
				arr[k] = aux[i++];

			} else if (aux[i] <= aux[j]) {
				arr[k] = aux[i++];
			} else {
				arr[k] = aux[j++];
				change += mid - i + 1;
			}

		}
	}
}