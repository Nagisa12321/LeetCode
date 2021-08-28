package com.leetcode.week.No236.nishi2;

import java.util.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/15 10:18
 */
public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int X = scanner.nextInt();
		int Y = scanner.nextInt();

		Digraph walkG = new Digraph(N);
		Digraph carG = new Digraph(N);
		for (int m = 0; m < M; m++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int p = scanner.nextInt();
			int q = scanner.nextInt();

			Edge walkEdge = new Edge(x, y, q);
			Edge carEdge = new Edge(y, x, p);

			walkG.addEdge(walkEdge);
			carG.addEdge(carEdge);
		}

		int[] wait = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			wait[i] = scanner.nextInt();
		}

		SP walkSP = new SP(walkG, X);
		SP carSP = new SP(carG, Y);

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int waitTime = Math.max(wait[i] - walkSP.distTo(i), 0);
			min = Math.min(walkSP.distTo(i) + carSP.distTo(i) + waitTime, min);
		}

		System.out.println(min);
	}
}

class Edge {
	private final int v;
	private final int w;
	private final int weight;

	public Edge(int v, int w, int weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int from() {
		return v;
	}

	public int to() {
		return w;
	}

	public int weight() {
		return weight;
	}

	public String toString() {
		return "[" + v + " -> " + w + ", " + weight + ']';
	}
}


class Digraph {

	// 邻接表
	private final List<Edge>[] edges;

	// V, E
	private final int V;
	private int E;
	
	public Digraph(int V) {
		this.V = V;
		this.E = 0;
		edges = new List[V + 1];
		for (int v = 1; v <= V; v++)
			edges[v] = new ArrayList<>();
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(Edge edge) {
		edges[edge.from()].add(edge);
		E++;
	}

	public Iterable<Edge> adj(int v) {
		return edges[v];
	}

}

class SP {
	private final Edge[] edgeTo;
	private final int[] distTo;

	public SP(Digraph G, int s) {
		// edgeTo[v] - s->v 的最短路径的最后一条边
		edgeTo = new Edge[G.V() + 1];
		// distTo[v] - s->v 的最短路径距离
		distTo = new int[G.V() + 1];

		// 全部初始化为最大值, 除了s->s
		Arrays.fill(distTo, Integer.MAX_VALUE);
		distTo[s] = 0;
		PriorityQueue<Integer> pq =
				new PriorityQueue<>(Comparator.
						comparingDouble(value -> distTo[value]));

		pq.offer(s);

		// 每个点只放松一次
		boolean[] marked = new boolean[G.V() + 1];
		while (!pq.isEmpty()) {
			// 要放松的点
			int v = pq.poll();

			if (marked[v]) continue;
			marked[v] = true;

			for (Edge edge : G.adj(v)) {
				int w = edge.to();
				if (distTo[w] > distTo[v] + edge.weight()) {
					distTo[w] = distTo[v] + edge.weight();
					edgeTo[w] = edge;
					pq.offer(w);
				}
			}
		}
	}

	public int distTo(int v) {
		return distTo[v];
	}
}
