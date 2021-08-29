package com.leetcode.queueorstack.BFS.No2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/6 10:25
 */

// ³¬Ê±
public class Solution3 {
	public int numSquares(int n) {
		Queue<Integer> queue = new LinkedList<>();
		HashSet<Integer> set = new HashSet<>();
		queue.offer(0);

		int step = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			step++;

			for (int i = 0; i < size; i++) {
				int cur = queue.poll();
				if (set.contains(cur)) continue;
				set.add(cur);

				for (int j = 1; j * j <= n; j++) {
					int nextSum = cur + j * j;
					if (nextSum == n) return step;
					if (nextSum < n) {
						queue.offer(nextSum);
					}
				}
			}

		}

		return -1;
	}
}