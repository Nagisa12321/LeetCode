package com.leetcode.interview.No17.No12;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/7 23:25
 */
public class Solution {

	private TreeNode result = null;
	private TreeNode trueResult = null;

	public TreeNode convertBiNode(TreeNode root) {
		dfs(root);
		return trueResult;
	}

	private void dfs(TreeNode node) {
		if (node == null) return ;

		dfs(node.left);
		if (result == null) {
			result = new TreeNode(node.val);
			trueResult = result;
		}
		else {
			result.right = new TreeNode(node.val);
			result = result.right;
		}
		dfs(node.right);
	}
}