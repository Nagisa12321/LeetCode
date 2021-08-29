package com.leetcode.algorithm.No1845;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/24 11:10
 */
public class SeatManager2 {

	private final int[] heap;
	private int size = 0;

	public SeatManager2(int n) {
		heap = new int[n];
		for (int i = 1; i <= n; i++) {
			heap[i - 1] = i;
		}
		this.size = n;
	}

	public int reserve() {
		int res = heap[0];
		swap(heap, 0, --size);
		heapify(heap, 0, size);
		return res;
	}

	public void unreserve(int seatNumber) {
		heap[size++] = seatNumber;
		heapify_up(heap, (size - 2) / 2, size);
	}

	private void heapify_up(int[] arr, int i, int n) {
		if (i < 0) return;

		int c1 = i * 2 + 1;
		int c2 = i * 2 + 2;
		int min = i;

		if (c1 < n && arr[c1] < arr[min]) { min = c1; }
		if (c2 < n && arr[c2] < arr[min]) { min = c2; }

		if (min != i) {
			swap(arr, min, i);
			heapify_up(arr, (i - 1) / 2, n);
		}
	}

	private void heapify(int[] arr, int i, int n) {
		if (i >= n) return;

		int c1 = i * 2 + 1;
		int c2 = i * 2 + 2;
		int min = i;
		if (c1 < n && arr[c1] < arr[min]) { min = c1; }
		if (c2 < n && arr[c2] < arr[min]) { min = c2; }

		if (min != i) {
			swap(arr, i, min);
			heapify(arr, min, n);
		}
	}

	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */