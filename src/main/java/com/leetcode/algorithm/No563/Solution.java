package com.leetcode.algorithm.No563;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/7 22:59
 */
public class Solution {
	private int tilt = 0;

	public int findTilt(TreeNode root) {
		if (root == null) return 0;

		int left = sum(root.left);
		int right = sum(root.right);
		tilt += Math.abs(left - right);

		return tilt;
	}

	private int sum(TreeNode root) {
		if (root == null) return 0;

		int left = sum(root.left);
		int right = sum(root.right);
		tilt += Math.abs(left - right);

		return left + right + root.val;
	}
}