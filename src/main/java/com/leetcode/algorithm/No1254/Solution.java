package com.leetcode.algorithm.No1254;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 11:54
 */
public class Solution {
	public int closedIsland(int[][] grid) {
		int len_i = grid.length;
		int len_j = grid[0].length;
		for (int i = 0; i < len_i; i++) {
			DFS(grid, i, 0, grid[i][0]);
			DFS(grid, i, len_j - 1, grid[i][len_j - 1]);
		}

		for (int j = 0; j < len_j; j++) {
			DFS(grid, 0, j, grid[0][j]);
			DFS(grid, len_i - 1, j, grid[len_i - 1][j]);
		}

		int num = 0;
		for (int i = 0; i < len_i; i++) {
			for (int j = 0; j < len_j; j++) {
				if (grid[i][j] == 0) {
					DFS(grid, i, j, 0);
					num++;
				}
			}
		}

		return num;
	}

	public void DFS(int[][] grid, int i, int j, int type) {
		if (i < 0 || i == grid.length || j < 0 || j == grid[0].length)
			return;

		if (grid[i][j] != type || grid[i][j] == 123) return;


		grid[i][j] = 123;
		DFS(grid, i - 1, j, type);
		DFS(grid, i + 1, j, type);
		DFS(grid, i, j - 1, type);
		DFS(grid, i, j + 1, type);
	}

}