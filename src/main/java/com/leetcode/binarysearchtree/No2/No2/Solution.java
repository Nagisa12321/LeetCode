package com.leetcode.binarysearchtree.No2.No2;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/6 12:26
 */
public class Solution {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) return new TreeNode(val);

		TreeNode node = root;
		while (true) {
			if (val > node.val) {
				if (node.right == null) {
					node.right = new TreeNode(val);
					return root;
				} else node = node.right;
			} else {
				if (node.left == null) {
					node.left = new TreeNode(val);
					return root;
				} else node = node.left;
			}
		}
	}
}