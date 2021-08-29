package com.leetcode.offer.No62;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/22 21:20
 */

// ³¬Ê±
public class Solution {
	public int lastRemaining(int n, int m) {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < n; i++)
			queue.offer(i);

		while (queue.size() != 1) {
			for (int i = 0; i < m; i++) {
				int tmp = queue.poll();
				if (i != m - 1) queue.offer(tmp);
			}
		}

		return queue.poll();
	}
}