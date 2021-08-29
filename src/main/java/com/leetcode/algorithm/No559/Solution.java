package com.leetcode.algorithm.No559;

import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/28 14:07
 */
public class Solution {
	public int maxDepth(Node root) {
		if (root == null) return 0;

		int max = 0;
		for (Node node : root.children)
			max = Math.max(maxDepth(node), max);

		return max + 1;
	}
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
