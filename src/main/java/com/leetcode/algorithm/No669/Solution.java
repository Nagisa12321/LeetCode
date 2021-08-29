package com.leetcode.algorithm.No669;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/8 16:21
 */
public class Solution {
	public TreeNode trimBST(TreeNode root, int low, int high) {
		if (root == null) return null;
		else if (root.val >= low && root.val <= high) {
			root.left = trimBST(root.left, low, high);
			root.right = trimBST(root.right, low, high);
			return root;
		} else {
			if (root.val > high) return trimBST(root.left, low, high);
			else return trimBST(root.right, low, high);
		}
	}
}