package com.leetcode.algorithm.No114;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/14 23:22
 */
public class Solution {

	private TreeNode result = null;
	private TreeNode cur = null;

	public void flatten(TreeNode root) {
		if (root == null) return;

		dfs(root);
		root.left = null;
		root.right = result.right;
	}

	public void dfs(TreeNode node) {
		if (node == null) return;

		if (result == null) {
			result = new TreeNode(node.val);
			cur = result;
		} else {
			cur.right = new TreeNode(node.val);
			cur = cur.right;
		}

		dfs(node.left);
		dfs(node.right);
	}
}