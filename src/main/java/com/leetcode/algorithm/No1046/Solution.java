package com.leetcode.algorithm.No1046;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/6 14:17
 */
public class Solution {
	public int lastStoneWeight(int[] stones) {
		int n = stones.length;
		buildHeap(stones, n);
		while (n > 1) {
			int one = stones[0];
			swap(stones, 0, --n);
			heapify(stones, n, 0);

			if (stones[0] == one) {
				if (n == 1) return 0;
				swap(stones, 0, --n);
			}
			else stones[0] = Math.abs(stones[0] - one);
			heapify(stones, n, 0);
		}
		return stones[0];
	}

	private void heapify(int[] stones, int n, int i) {
		if (i >= n) return;

		int c1 = i * 2 + 1;
		int c2 = i * 2 + 2;
		int max = i;

		if (c1 < n && stones[c1] > stones[max]) max = c1;
		if (c2 < n && stones[c2] > stones[max]) max = c2;

		if (max != i) {
			swap(stones, max, i);
			heapify(stones, n, max);
		}
	}

	private void buildHeap(int[] arr, int n) {
		int last_index = (arr.length - 1) / 2;
		for (int i = last_index; i >= 0; i--) {
			heapify(arr, n, i);
		}
	}

	private void swap(int[] arr, int a, int b) {
		arr[a] ^= arr[b];
		arr[b] ^= arr[a];
		arr[a] ^= arr[b];
	}
}