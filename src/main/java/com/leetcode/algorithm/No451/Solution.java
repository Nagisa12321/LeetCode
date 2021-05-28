package com.leetcode.algorithm.No451;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/15 10:34
 */
public class Solution {
	public String frequencySort(String s) {
		char[] chs = s.toCharArray();
		int[] map = new int[128];


		int len = 0;
		for (char ch : chs) {
			if (map[ch] == 0) len++;
			map[ch]++;
		}


		char[] tmp = new char[len];
		int idx = 0;
		for (int i = 0; i < 128; i++) {
			if (map[i] != 0) {
				tmp[idx++] = (char) i;
			}
		}

		heapSort(tmp, tmp.length, map);

		StringBuilder builder = new StringBuilder();
		for (char c : tmp) {
			builder.append(String.valueOf(c).repeat(map[c]));
		}

		return builder.toString();
	}

	public void heapify(char[] tree, int i, int n, int[] map) {
		int c1 = i * 2 + 1;
		int c2 = i * 2 + 2;
		int max = i;
		if (c1 < n && map[tree[c1]] < map[tree[max]]) max = c1;
		if (c2 < n && map[tree[c2]] < map[tree[max]]) max = c2;

		if (i != max) {
			swap(tree, i, max);

			heapify(tree, max, n, map);
		}
	}

	public void swap(char[] arr, int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public void buildHeap(char[] tree, int n, int[] map) {
		int last_node = n - 1;
		int last_parent = (last_node - 1) / 2;
		for (int i = last_parent; i >= 0; i--) {
			heapify(tree, i, n, map);
		}
	}

	public void heapSort(char[] tree, int n, int[] map) {
		buildHeap(tree, n, map);
		for (int i = n - 1; i >= 0; i--) {
			swap(tree, 0, i);
			heapify(tree, 0, i, map);
		}
	}
}