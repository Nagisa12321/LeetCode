package com.leetcode.binarysearchtree.No2.No1;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/6 12:14
 */
public class Solution2 {
	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) return null;

		TreeNode node = root;

		while (node != null) {
			if (val == node.val) return node;
			else if (val > node.val) node = node.right;
			else node = node.left;
		}

		return null;
	}
}