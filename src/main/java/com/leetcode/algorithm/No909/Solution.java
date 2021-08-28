package com.leetcode.algorithm.No909;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/27 18:18
 */
public class Solution {
	private int len_i;
	private int len_j;
	public int snakesAndLadders(int[][] board) {
		len_i = board.length;
		len_j = board[0].length;
		int end = len_i * len_j;

		Queue<Integer> queue = new LinkedList<>();
		HashSet<Integer> set = new HashSet<>();
		queue.offer(1);
		int step = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				if (cur == end) return step;
				for (int j = 1; j <= 6; j++) {
					if (cur + j > end) continue;
					int[] p = parse(cur + j);
					if (board[p[0]][p[1]] == -1) {
						if (set.contains(cur + j))
							continue;
						set.add(cur + j);
						queue.offer(cur + j);
					} else {
						int jump = board[p[0]][p[1]];
						if (set.contains(jump))
							continue;
						set.add(jump);
						queue.offer(jump);
					}
				}
			}
			step++;
		}
		return -1;
	}

	public int[] parse(int cur) {
		int x = len_i - 1 - (cur - 1) / len_j;
		int tmp = (cur - 1) / len_j;
		int y;
		if (tmp % 2 == 0) {
			y = (cur - 1) % len_j;
		} else {
			y = len_j - 1 - (cur - 1) % len_j;
		}
		return new int[]{x, y};
	}

}