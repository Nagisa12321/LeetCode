package com.leetcode.algorithm.No513;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/14 14:54
 */
public class Solution {
	public int findBottomLeftValue(TreeNode root) {
		int deep = deep(root);
		return findLeft(root, deep, 1).val;
	}

	private TreeNode findLeft(TreeNode root, int deep, int nowDeep) {
		if (root == null) return null;
		else if (nowDeep == deep) return root;
		TreeNode left = findLeft(root.left, deep, nowDeep + 1);
		if (left != null) return left;
		else return findLeft(root.right, deep, nowDeep + 1);
	}

	private int deep(TreeNode root) {
		if (root == null) return 0;
		return 1 + Math.max(deep(root.left), deep(root.right));
	}
}