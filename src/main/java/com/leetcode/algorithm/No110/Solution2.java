package com.leetcode.algorithm.No110;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/10 14:51
 */
public class Solution2 extends Solution {
	@Override
	public boolean isBalanced(TreeNode root) {
		return height(root) != -1;
	}

	public int height(TreeNode node) {
		if (node == null) return 0;

		int left = height(node.left);
		int right = height(node.right);

		if (left == -1 || right == -1 || Math.abs(left - right) > 1)
			return -1;

		return Math.max(left, right) + 1;
	}
}
