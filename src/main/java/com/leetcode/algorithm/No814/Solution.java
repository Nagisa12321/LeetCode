package com.leetcode.algorithm.No814;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/14 18:35
 */
public class Solution {
	public TreeNode pruneTree(TreeNode root) {
		if (root == null) return null;
		else if (root.val == 1) {
			TreeNode left = pruneTree(root.left);
			TreeNode right = pruneTree(root.right);
			root.left = left;
			root.right = right;
			return root;
		} else {
			TreeNode left = pruneTree(root.left);
			TreeNode right = pruneTree(root.right);
			if (left == null && right == null) {
				return null;
			} else {
				root.left = left;
				root.right = right;
				return root;
			}
		}
	}
}