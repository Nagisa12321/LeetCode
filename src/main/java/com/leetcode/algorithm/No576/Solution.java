package com.leetcode.algorithm.No576;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/15 20:41
 */
public class Solution {
	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		// 预处理 - square[i][j] - 出界最少走几步
		int[][] square = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				square[i][j] = Math.min(Math.min(m - i, i + 1),
						Math.min(n - j, j + 1));
			}
		}

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{startRow, startColumn});
		int res = 0;
		for (int i = 0; i <= maxMove; i++) {
			int size = q.size();
			for (int j = 0; j < size; j++) {
				int[] cur = q.poll();
				if (out(cur, m, n)) {
					res++;
				}
				else {
					if (square[cur[0]][cur[1]] <= maxMove - i + 1) {
						q.offer(new int[]{cur[0] + 1, cur[1]});
						q.offer(new int[]{cur[0] - 1, cur[1]});
						q.offer(new int[]{cur[0], cur[1] + 1});
						q.offer(new int[]{cur[0], cur[1] - 1});
					}
				}
			}
		}
		return res;
	}

	public boolean out(int[] pos, int m, int n) {
		return pos[0] < 0 || pos[0] >= m || pos[1] < 0 || pos[1] >= n;
	}
}