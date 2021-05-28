package com.leetcode.week.No236.mianshi.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/9 0:55
 */
public class MergeSort1 {
	public void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	}


	private void mergeSort(int[] arr, int L, int R) {
		if (L >= R) return;

		int M = (L + R) / 2;
		mergeSort(arr, L, M);
		mergeSort(arr, M + 1, R);
		merge(arr, L, M + 1, R);
	}

	//  L            M        R
	//  0  1  2  3   4  5  6  7
	// [2, 8, 9, 10, 4, 5, 6, 7]
	public void merge(int[] arr, int L, int M, int R) {
		int left_size = M - L;
		int right_size = R - M + 1;
		int[] left_arr = new int[left_size];
		int[] right_arr = new int[right_size];
		System.arraycopy(arr, L, left_arr, 0, M - L);
		System.arraycopy(arr, M, right_arr, 0, R + 1 - M);

		int left = 0, right = 0;
		int idx = L;
		while (left != left_size || right != right_size) {
			int max;
			if (left == left_size || (right != right_size && right_arr[right] < left_arr[left])) {
				max = right_arr[right++];
			} else {
				max = left_arr[left++];
			}
			arr[idx++] = max;
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
		MergeSort1 mergeSort = new MergeSort1();
		int[] nums1 = {1, 4, 2, 8, 5, 7};
		int[] nums2 = randomInts();
		int[] nums3 = {2, 8, 4, 10, 5, 9, 6, 7};
		mergeSort.mergeSort(nums1);

		System.out.println(Arrays.toString(nums1));
	}
}
