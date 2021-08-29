package com.leetcode.algorithm.No783;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/7 23:17
 */
public class Solution {
	private int last = Integer.MIN_VALUE / 2;
	private int min = Integer.MAX_VALUE / 2;
	public int minDiffInBST(TreeNode root) {
		dfs(root);
		return min;
	}

	private void dfs(TreeNode node) {
		if (node == null) return ;

		dfs(node.left);
		min = Math.min(node.val - last, min);
		last = node.val;
		dfs(node.right);
	}

}