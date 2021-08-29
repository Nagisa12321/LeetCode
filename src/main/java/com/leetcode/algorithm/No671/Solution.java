package com.leetcode.algorithm.No671;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/27 9:16
 */
public /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	public int findSecondMinimumValue(TreeNode root) {
		if (root == null) return -1;
		else if (!hasTwoChildren(root)) return -1;
		int left = findSecondMinimumValue(root.left);
		int right = findSecondMinimumValue(root.right);
		if (root.val == root.left.val && root.val == root.right.val) {
			if (left == -1) return right;
			else if (right == -1) return left;
			else return left < right ? left : right;
		}
		int small = root.val == root.left.val ? root.right.val : root.left.val;
		int min = small;
		if (left != -1) min = Math.min(min, left);
		if (right != -1) min = Math.min(min, right);

		return min;
	}

	private boolean hasTwoChildren(TreeNode node) {
		return node.left != null && node.right != null;
	}
}