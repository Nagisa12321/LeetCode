package com.leetcode.binarysearchtree.No2.No1;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/6 12:13
 */
public class Solution {
	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) return null;
		else if (root.val == val) return root;
		else if (root.val > val) return searchBST(root.left, val);
		else return searchBST(root.right, val);
	}
}