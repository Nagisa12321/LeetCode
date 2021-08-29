package com.leetcode.algorithm.No654;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/28 10:05
 */
public class Solution {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructMaximumBinaryTree(nums, 0, nums.length - 1);
	}

	private TreeNode constructMaximumBinaryTree(int[] nums, int lo, int hi) {
		if (lo > hi) return null;
		else if (lo == hi) { return new TreeNode(nums[lo]); }
		int max = nums[lo];
		int idx = lo;
		for (int i = lo; i <= hi; i++) {
			if (nums[i] > max) {
				max = nums[i];
				idx = i;
			}
		}

		TreeNode node = new TreeNode(max);
		node.left = constructMaximumBinaryTree(nums, lo, idx - 1);
		node.right = constructMaximumBinaryTree(nums, idx + 1, hi);
		return node;
	}
}