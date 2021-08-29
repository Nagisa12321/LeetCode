package com.leetcode.algorithm.No1964;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/20 10:49
 */
public class Solution2 {
	public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
		PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
		Stack<Integer> stack = new Stack<>();
		int n = obstacles.length;
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			pq.offer(obstacles[i]);
			while (!pq.isEmpty()) {
				if (pq.peek() <= obstacles[i])
					break;
				stack.push(pq.poll());
			}
			res[i] = pq.size();
			while (!stack.isEmpty())
				pq.offer(stack.pop());
		}
		return res;
	}
}