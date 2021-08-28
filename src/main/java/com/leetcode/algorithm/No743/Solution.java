package com.leetcode.algorithm.No743;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/2 10:01
 */
public class Solution {
	public int networkDelayTime(int[][] times, int n, int k) {
		List<Edge>[] edges = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int[] time : times) {
			int from = time[0];
			int to = time[1];
			int weight = time[2];
			edges[from].add(new Edge(from, to, weight));
		}

		int[] distTo = new int[n + 1];
		Edge[] edgeTo = new Edge[n + 1];
		boolean[] marked = new boolean[n + 1];
		for (int i = 1; i <= n; i++)
			distTo[i] = Integer.MAX_VALUE;

		PriorityQueue<Integer> queue = new PriorityQueue<>((i1, i2) -> {
			return distTo[i1] - distTo[i2];
		});
		distTo[k] = 0;
		queue.offer(k);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if (marked[cur])
				continue;
			marked[cur] = true;

			for (Edge edge : edges[cur])
				if (distTo[cur] + edge.weight <= distTo[edge.to]) {
					distTo[edge.to] = distTo[cur] + edge.weight;
					edgeTo[edge.to] = edge;
					queue.offer(edge.to);
				}
		}
		for (int i = 1; i <= n; i++)
			if (distTo[i] == Integer.MAX_VALUE)
				return -1;
		int max = 0;
		for (int i = 1; i <= n; i++) {
			max = Math.max(distTo[i], max);
		}

		return max;
	}

	private static class Edge {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
}