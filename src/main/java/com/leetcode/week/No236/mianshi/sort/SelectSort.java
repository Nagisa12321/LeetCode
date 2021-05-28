package com.leetcode.week.No236.mianshi.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/9 0:14
 */
public class SelectSort {
	public void selectSort(int[] arr) {
		for (int i = arr.length; i > 0; i--) {
			select(arr, i);
		}
	}

	public void select(int[] arr, int n) {
		int max = arr[n - 1];
		int idx = n - 1;
		for (int i = 0; i < n; i++) {
			if (arr[i] > max) {
				max = arr[i];
				idx = i;
			}
		}
		if (idx != n - 1) {
			swap(arr, idx, n - 1);
		}
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static int[] randomInts() {
		int[] res = new int[10000];
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			res[i] = random.nextInt();
		}
		return res;
	}

	public static void main(String[] args) {
		SelectSort selectSort = new SelectSort();
		int[] nums1 = {1, 4, 2, 8, 5, 7};
		int[] nums2 = randomInts();
		selectSort.selectSort(nums1);

		System.out.println(Arrays.toString(nums1));
	}
}
