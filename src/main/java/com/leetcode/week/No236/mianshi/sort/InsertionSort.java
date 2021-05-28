package com.leetcode.week.No236.mianshi.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/9 0:25
 */
public class InsertionSort {
	public void insertionSort(int[] arr) {
		for (int i = 1; i <= arr.length; i++) {
			insert(arr, i);
		}
	}

	// n = 4
	//  0  1  2   3
	// (3, 6, 7), 4
	// 3, 6, 7, 7
	// 3, 6, 6, 7
	// 3, 4, 6, 7
	public void insert(int[] arr, int n) {
		int key = arr[n - 1]; // key = 4;
		int i = n - 1; // i = 3
		while (i > 0 && arr[i - 1] > key) {
			arr[i] = arr[i - 1];
			i--;
		}
		arr[i] = key;
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
		InsertionSort insertionSort = new InsertionSort();
		int[] nums1 = {1, 4, 2, 8, 5, 7};
		int[] nums2 = randomInts();
		insertionSort.insertionSort(nums1);

		System.out.println(Arrays.toString(nums1));
	}
}
