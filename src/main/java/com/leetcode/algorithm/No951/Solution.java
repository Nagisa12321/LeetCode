package com.leetcode.algorithm.No951;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/16 10:40
 */
public class Solution {
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) return true;
		else if (root1 == null || root2 == null) return false;
		else if (root1.val != root2.val) return false;

		return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
				(flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right));
	}
}