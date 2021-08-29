package com.leetcode.binarysearchtree.No2.No2;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/6 12:29
 */
public class Solution2 {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) return new TreeNode(val);

		if (val > root.val) root.right = insertIntoBST(root.right, val);
		else root.left = insertIntoBST(root.left, val);

		return root;
	}
}