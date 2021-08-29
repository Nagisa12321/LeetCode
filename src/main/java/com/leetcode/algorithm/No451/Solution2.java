package com.leetcode.algorithm.No451;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/15 14:17
 */
public class Solution2 {
	public String frequencySort(String s) {
		char[] chs = s.toCharArray();
		int[] map = new int[128];


		int len = 0;
		for (char ch : chs) {
			if (map[ch] == 0) len++;
			map[ch]++;
		}


		int[][] tmp = new int[len][2];
		int idx = 0;
		for (int i = 0; i < 128; i++) {
			if (map[i] != 0) {
				tmp[idx][0] = i;
				tmp[idx++][1] = map[i];
			}
		}

		heapSort(tmp, tmp.length, map);

		idx = 0;
		for (int[] c : tmp) {
			for (int i = 0; i < c[1]; i++) {
				chs[idx++] = (char) c[0];
			}
		}

		return new String(chs);
	}

	public void heapify(int[][] tree, int i, int n) {
		int c1 = i * 2 + 1;
		int c2 = i * 2 + 2;
		int max = i;
		if (c1 < n && tree[c1][1] < tree[max][1]) max = c1;
		if (c2 < n && tree[c2][1] < tree[max][1]) max = c2;

		if (i != max) {
			swap(tree, i, max);

			heapify(tree, max, n);
		}
	}

	public void swap(int[][] arr, int i, int j) {
		int[] tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public void buildHeap(int[][] tree, int n) {
		int last_node = n - 1;
		int last_parent = (last_node - 1) / 2;
		for (int i = last_parent; i >= 0; i--) {
			heapify(tree, i, n);
		}
	}

	public void heapSort(int[][] tree, int n, int[] map) {
		buildHeap(tree, n);
		for (int i = n - 1; i >= 0; i--) {
			swap(tree, 0, i);
			heapify(tree, 0, i);
		}
	}
}
