package com.leetcode.queueorstack.DFS.No2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/2 12:09
 */
public class Solution {
	private final HashMap<Node, Node> map = new HashMap<>();
	private final HashSet<Node> set = new HashSet<>();

	public Node cloneGraph(Node node) {
		dfs(node);
		dfs0(node);

		return map.get(node);
	}

	public void dfs(Node root) {
		if (root == null || map.containsKey(root)) return;
		Node newNode = new Node(root.val);
		map.put(root, newNode);

		for (Node node : root.neighbors)
			dfs(node);
	}

	public void dfs0(Node root) {
		if (root == null || set.contains(root)) return;

		set.add(root);
		Node newNode = map.get(root);
		for (Node node : root.neighbors) {
			newNode.neighbors.add(map.get(node));
		}
		for (Node node : root.neighbors) {
			dfs0(node);
		}
	}
}

// Definition for a Node.
class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}
