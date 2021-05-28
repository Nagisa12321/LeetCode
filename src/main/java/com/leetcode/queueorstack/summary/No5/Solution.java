package com.leetcode.queueorstack.summary.No5;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/4 11:00
 */
public class Solution {
	private static final int NUM = 413;
	public int[][] updateMatrix(int[][] matrix) {
		int x_len = matrix.length;
		int y_len = matrix[0].length;
		int[][] ret = new int[x_len][y_len];
		Queue<int[]> queue = new LinkedList<>();
		int[][] visits = new int[x_len][y_len];

		for (int i = 0; i < x_len; i++)
			for (int j = 0; j < y_len; j++)
				if (matrix[i][j] == 0) {
					int[] ints = {i, j};
					queue.offer(ints);
					visits[i][j] = 1;
				}
		int step = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] tmp = queue.poll();

				assert tmp != null;
				int x = tmp[0];
				int y = tmp[1];

				ret[x][y] = step;

				if (x - 1 >= 0 && visits[x- 1][y] != 1) {
					int[] ints1 = {x - 1, y};
					queue.offer(ints1);
					visits[x - 1][y] = 1;
				}
				if (x + 1 < x_len && visits[x + 1][y] != 1) {
					int[] ints1 = {x + 1, y};
					queue.offer(ints1);
					visits[x + 1][y] = 1;
				}
				if (y - 1 >= 0 && visits[x][y - 1] != 1) {
					int[] ints1 = {x, y - 1};
					queue.offer(ints1);
					visits[x][y - 1] = 1;
				}
				if (y + 1 < y_len && visits[x][y + 1] != 1) {
					int[] ints1 = {x, y + 1};
					queue.offer(ints1);
					visits[x][y + 1] = 1;
				}
			}
			step++;
		}

		return ret;
	}
}