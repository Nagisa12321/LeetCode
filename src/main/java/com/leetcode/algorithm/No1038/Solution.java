package com.leetcode.algorithm.No1038;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/8 15:32
 */
public class Solution {
	private int[] sum;
	private int idx;
	public TreeNode bstToGst(TreeNode root) {
		int len = size(root);
		sum = new int[len];
		idx = 0;
		dfs(root);
		idx = len - 1;
		dfs_reserve(root);

		return root;
	}

	private int size(TreeNode root) {
		if (root == null) return 0;
		return 1 + size(root.left) + size(root.right);
	}

	private void dfs(TreeNode root) {
		if (root == null) return ;

		dfs(root.left);
		sum[idx++] = root.val;
		dfs(root.right);
	}

	private void dfs_reserve(TreeNode root) {
		if (root == null) return ;

		dfs_reserve(root.right);
		if (idx != sum.length - 1)
			sum[idx] += sum[idx + 1];
		root.val = sum[idx--];
		dfs_reserve(root.left);
	}

}