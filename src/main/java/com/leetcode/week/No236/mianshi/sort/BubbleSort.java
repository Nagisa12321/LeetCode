package com.leetcode.week.No236.mianshi.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/8 23:59
 */
public class BubbleSort {

//	public void sort(int[] arr) {
//		for (int i = 1; i <= arr.length; i++) {
//			for (int j = 0; j < arr.length - i; j++) {
//				if (arr[j] > arr[j + 1]) {
//					int tmp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = tmp;
//				}
//			}
//		}
//	}

	public void sort(int[] arr) {
		sort(arr, arr.length);
	}

	private void sort(int[] arr, int n) {
		if (n <= 0) return;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1])
				swap(arr, i, i + 1);
		}
		sort(arr, n - 1);
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
		BubbleSort bubbleSort = new BubbleSort();
		int[] nums1 = {1, 4, 2, 8, 5, 7};
		int[] nums2 = randomInts();
		bubbleSort.sort(nums2);

		System.out.println(Arrays.toString(nums2));
	}
}
