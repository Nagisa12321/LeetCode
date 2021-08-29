package com.leetcode.queueorstack.DFS.No2;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
	private final Solution solution = new Solution();

	@Test
	public void cloneGraph() {

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);

		node1.neighbors.add(node2);
		node1.neighbors.add(node4);

		node2.neighbors.add(node1);
		node2.neighbors.add(node3);

		node3.neighbors.add(node2);
		node3.neighbors.add(node4);

		node4.neighbors.add(node1);
		node4.neighbors.add(node3);

		System.out.println(solution.cloneGraph(node1));
	}
}