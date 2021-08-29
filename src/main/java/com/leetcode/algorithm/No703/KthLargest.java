package com.leetcode.algorithm.No703;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/6 14:56
 */
public class KthLargest {

	private final int[] heap;
	private final int k;
	private int n; // 真实堆的大小.

	public KthLargest(int k, int[] nums) {
		this.k = k;
		n = 0;
		heap = new int[k];
		for (int num : nums) {
			if (n == k) {
				swap(heap, 0, --n);
				heapify_down(heap, n, 0);
			}
			heap[n++] = num;
			heapify(heap, n, (n - 2) / 2);
		}
	}

	public int add(int val) {
		int result = 0;
		if (n == k) {
			result = heap[0];
			swap(heap, 0, --n);
			heapify_down(heap, n, 0);
		}
		heap[n++] = val;
		heapify(heap, n, (n - 2) / 2);
		return result;
	}

	// 每次添加元素都必须进行heapify
	private void heapify(int[] arr, int n, int i) {
		if (i < 0) return;

		int c1 = i * 2 + 1;
		int c2 = i * 2 + 2;
		int max = i;
		if (c1 < n && arr[c1] < arr[max]) max = c1;
		if (c2 < n && arr[c2] < arr[max]) max = c2;

		if (i != max) {
			swap(arr, i, max);
			heapify(arr, n, (i - 1) / 2);
		}
	}

	private void heapify_down(int[] arr, int n, int i) {
		if (i >= n) return;

		int c1 = i * 2 + 1;
		int c2 = i * 2 + 2;
		int max = i;
		if (c1 < n && arr[c1] < arr[max]) max = c1;
		if (c2 < n && arr[c2] < arr[max]) max = c2;

		if (i != max) {
			swap(arr, i, max);
			heapify(arr, n, max);
		}
	}

	private void swap(int[] arr, int a, int b) {
		arr[a] ^= arr[b];
		arr[b] ^= arr[a];
		arr[a] ^= arr[b];
	}
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */