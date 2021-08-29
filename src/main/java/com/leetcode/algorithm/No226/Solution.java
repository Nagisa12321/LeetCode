package com.leetcode.algorithm.No226;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/26 23:27
 */
public class Solution {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;

		root.left = invertTree(root.left);
		root.right = invertTree(root.right);

		return root;
	}
}