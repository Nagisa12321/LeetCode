package com.leetcode.algorithm.No938;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/7 22:54
 */
public class Solution {

	private int sum;

	public int rangeSumBST(TreeNode root, int low, int high) {
		sum = 0;
		dfs(root, low, high);

		return sum;
	}

	private void dfs(TreeNode node, int low, int high) {
		if (node == null) return;

		dfs(node.left, low, high);
		if (node.val >= low && node.val <= high)
			sum += node.val;
		dfs(node.right, low, high);
	}
}