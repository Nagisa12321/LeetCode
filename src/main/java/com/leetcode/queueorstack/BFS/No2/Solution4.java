package com.leetcode.queueorstack.BFS.No2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/6 10:47
 */
public class Solution4 {
	public int numSquares(int n) {
		Queue<Integer> queue = new LinkedList<>();
		HashSet<Integer> set = new HashSet<>();
		queue.offer(n);

		int step = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			step++;

			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				if (set.contains(cur)) continue;
				set.add(cur);

				for (int j = 1; j * j <= n; j++) {
					int next = cur - j * j;
					if (next == 0) return step;
					if (next > 0) {
						queue.offer(next);
					}
				}
			}

		}

		return -1;
	}
}
