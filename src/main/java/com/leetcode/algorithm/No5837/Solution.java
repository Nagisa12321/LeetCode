package com.leetcode.algorithm.No5837;

import java.util.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/22 10:42
 */
public class Solution {

	public int countPaths(int n, int[][] roads) {
		List<Edge>[] nodes = new List[n];
		long MOD = (long)(1e9 + 7);
		for (int i = 0; i < n; i++) {
			nodes[i] = new ArrayList<>();
		}

		// make the graph
		for (int i = 0; i < roads.length; i++) {
			int s = roads[i][0];
			int v = roads[i][1];
			int weight = roads[i][2];

			Edge edge = new Edge(s, v, weight);
			nodes[s].add(edge);
			nodes[v].add(edge);
		}

		boolean[] marked = new boolean[n];
		long[] distTo = new long[n];


		PriorityQueue<Integer> pq =
				new PriorityQueue<>(Comparator.
						comparingDouble(value -> distTo[value]));
		Arrays.fill(distTo, Long.MAX_VALUE);
		distTo[0] = 0;
		pq.offer(0);

		long[] waysto = new long[n];
		waysto[0] = 1;

		while (!pq.isEmpty()) {
			// 要放松的点
			int v = pq.poll();

			if (marked[v]) continue;
			marked[v] = true;

			for (Edge edge : nodes[v]) {
				int w = edge.another(v);
				if (distTo[w] > distTo[v] + edge.weight()) {
					distTo[w] = distTo[v] + edge.weight();
					waysto[w] = waysto[v];
					pq.offer(w);
				} else if (distTo[w] == distTo[v] + edge.weight()) {
					waysto[w] += waysto[v];
					waysto[w] %= MOD;
				}
			}
		}

		return (int) (waysto[n - 1] % MOD);
	}


	private static class Edge {
		private final int s;
		private final int v;
		private final int weight;

		public Edge(int s, int v, int weight) {
			this.s = s;
			this.v = v;
			this.weight = weight;
		}

		public int other() {
			return s;
		}

		public int another(int s) {
			if (s == this.s)
				return v;
			else return this.s;
		}

		public int weight() {
			return weight;
		}
	}
}