package com.leetcode.week.No236.mianshi.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/9 0:55
 */
public class MergeSort {
	public void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}


	private void mergeSort(int[] arr, int L, int R) {
		if (L == R) return;

		int M = (R + L) / 2;
		mergeSort(arr, L, M);
		mergeSort(arr, M + 1, R);
		merge(arr, L, M + 1, R);
	}

	//  L            M        R
	//  0  1  2  3   4  5  6  7
	// [2, 8, 9, 10, 4, 5, 6, 7]
	public void merge(int[] arr, int L, int M, int R) {
		// if (L < 0 || R >= arr.length) return;
		int left_size = M - L;
		int right_size = R - M + 1;
		int[] left = new int[left_size];
		int[] right = new int[right_size];
		if (left_size >= 0) System.arraycopy(arr, L, left, 0, left_size);
		if (right_size >= 0) System.arraycopy(arr, M, right, 0, right_size);

		int le = 0;
		int ri = 0;
		int idx = L;
		while (le != left_size || ri != right_size) {
			int cur;
			if (le == left_size) {
				cur = right[ri++];
			} else if (ri == right_size) {
				cur = left[le++];
			} else if (left[le] <= right[ri]) {
				cur = left[le++];
			} else cur = right[ri++];

			arr[idx++] = cur;
		}
	}

	public static int[] randomInts() {
		int[] res = new int[1000000];
		Random random = new Random();
		for (int i = 0; i < 1000000; i++) {
			res[i] = random.nextInt();
		}
		return res;
	}

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] nums1 = {1, 4, 2, 8, 5, 7};
		int[] nums2 = randomInts();
		int[] nums3 = {2, 8, 4, 10, 5, 9, 6, 7};
		mergeSort.mergeSort(nums2);

		System.out.println(Arrays.toString(nums2));
	}
}
