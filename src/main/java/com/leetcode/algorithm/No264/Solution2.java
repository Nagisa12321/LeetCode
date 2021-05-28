package com.leetcode.algorithm.No264;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/13 19:32
 */
public class Solution2 {
	public int nthUglyNumber(int n) {
		// int[] heap = new int[1000];
		ArrayList<Long> heap = new ArrayList<>();
		HashSet<Long> set = new HashSet<>();

		heap.add(1L);
		set.add(1L);
		for (int i = 0; i < n - 1; i++) {
			// 拿走堆顶元素, 并放入三个
			long smallest = heap.get(0);
			// set.remove(smallest);
			swap(heap, heap.size() - 1, 0);
			heap.remove(heap.size() - 1);

			heapify_down(heap, 0);

			long[] put_in = {smallest * 2, smallest * 3, smallest * 5};
			for (int j = 0; j < 3; j++) {
				// set中没有该元素, 则放入堆中
				if (set.add(put_in[j])) {
					heap.add(put_in[j]);
 					heapify_up(heap, (heap.size() - 2) / 2);
				}
			}
		}
		return Math.toIntExact(heap.get(0));

	}

	private void heapify_down(ArrayList<Long> arr, int x) {
		if (x > arr.size()) return;
		int c1 = x * 2 + 1;
		int c2 = x * 2 + 2;
		int max = x;

		if (c1 < arr.size() && arr.get(c1) < arr.get(max)) max = c1;
		if (c2 < arr.size() && arr.get(c2) < arr.get(max)) max = c2;

		if (max != x) {
			swap(arr, max, x);
			heapify_down(arr, max);
		}

	}

	private void heapify_up(ArrayList<Long> arr, int x) {
		if (x <= 0) return;
		int c1 = x * 2 + 1;
		int c2 = x * 2 + 2;
		int max = x;

		if (c1 < arr.size() && arr.get(c1) < arr.get(max)) max = c1;
		if (c2 < arr.size() && arr.get(c2) < arr.get(max)) max = c2;

		if (max != x) {
			swap(arr, max, x);
			heapify_up(arr, (x - 1) / 2);
		}
	}

	private void swap(ArrayList<Long> arr, int i, int j) {
		long tmp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, tmp);
	}
}