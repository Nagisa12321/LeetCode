package com.leetcode.algorithm.No973;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/14 9:11
 */
public class Solution {
	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] * x[0] + x[1] * x[1] - y[0] * y[0] - y[1] * y[1]);
		for (int[] point : points) {
			pq.offer(point);
		}
		int[][] result = new int[k][2];
		for (int i = 0; i < k; i++) {
			result[i] = pq.poll();
		}

		return result;
	}
}