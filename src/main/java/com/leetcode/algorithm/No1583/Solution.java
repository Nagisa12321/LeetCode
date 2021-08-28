package com.leetcode.algorithm.No1583;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/14 10:20
 */
public class Solution {
	public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
		for (int i = 0; i < n; i++) {
			int[] map = new int[n];
			for (int j = 0; j < n - 1; j++)
				map[preferences[i][j]] = n - j;
			preferences[i] = map;
		}
		boolean[] sad = new boolean[n];
		for (int i = 0; i < pairs.length; i++) {
			int x = pairs[i][0];
			int y = pairs[i][1];
			for (int j = 0; j < pairs.length; j++) {
				if (j == i)
					continue;
				int u = pairs[j][0];
				int v = pairs[j][1];

				if (preferences[x][y] < preferences[x][u] && preferences[u][v] < preferences[u][x])
					sad[x] = true;
				else if (preferences[x][y] < preferences[x][v] && preferences[v][u] < preferences[v][x])
					sad[x] = true;

				if (preferences[y][x] < preferences[y][u] && preferences[u][v] < preferences[u][y])
					sad[y] = true;
				else if (preferences[y][x] < preferences[y][v] && preferences[v][u] < preferences[v][y])
					sad[y] = true;
			}
		}

		int res = 0;
		for (int i = 0; i < n; i++)
			if (sad[i])
				res++;
		return res;
	}
}