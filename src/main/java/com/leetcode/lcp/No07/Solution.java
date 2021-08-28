package com.leetcode.lcp.No07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/1 9:41
 */
public class Solution {
	private int res;
	public int numWays(int n, int[][] relation, int k) {
		HashMap<Integer, Node> map = new HashMap<>();
		for (int i = 0; i < relation.length; i++) {
			Node node1, node2;
			if (map.containsKey(relation[i][0]))
				node1 = map.get(relation[i][0]);
			else {
				node1 = new Node(relation[i][0]);
				map.put(relation[i][0], node1);
			}
			if (map.containsKey(relation[i][1]))
				node2 = map.get(relation[i][1]);
			else {
				node2 = new Node(relation[i][1]);
				map.put(relation[i][1], node2);
			}

			node1.children.add(node2);
		}
		res = 0;
		dfs(map.get(0), 0, k, n);
		return res;
	}

	private void dfs(Node node, int dept, int k, int n) {
		if (node == null) return;
		else if (dept == k) {
			if (node.value == n - 1)
				res++;
			return;
		}
		for (Node child : node.children) {
			dfs(child, dept + 1, k, n);
		}
	}

	private static class Node {
		int value;
		List<Node> children;

		Node(int value) {
			this.children = new ArrayList<>();
			this.value = value;
		}
	}
}