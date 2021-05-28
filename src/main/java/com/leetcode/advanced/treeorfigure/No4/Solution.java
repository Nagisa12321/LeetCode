package com.leetcode.advanced.treeorfigure.No4;

import com.leetcode.struct.TreeNode;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/27 22:24
 */
public class Solution {
	private HashMap<TreeNode, TreeNode> map;
	private HashMap<TreeNode, int[]> intsMap;
	private int max;

	public int maxPathSum(TreeNode root) {
		intsMap = new HashMap<>();
		map = new HashMap<>();
		max = Integer.MIN_VALUE;
		map.put(root, null);
		dfs(root);
		dfs0(root);
		dfs1(root);

		return max;
	}

	// 遍历所有节点并且添加父子关系
	public void dfs(TreeNode root) {
		if (root == null)
			return;

		if (root.left != null)
			map.put(root.left, root);
		if (root.right != null)
			map.put(root.right, root);
		dfs(root.left);
		dfs(root.right);
	}

	public int dfs0(TreeNode root) {
		if (root == null) return -1;
		if (intsMap.containsKey(root)) {
			int[] ints = intsMap.get(root);
			return Math.max(ints[0], ints[1]);
		}

		int left = dfs0(root.left);
		int right = dfs0(root.right);

		int[] ints = {left < 0 ? root.val : left + root.val, right < 0 ? root.val : right + root.val};
		intsMap.put(root, ints);

		return Math.max(ints[0], ints[1]);

	}

	public void dfs1(TreeNode root) {
		if (root == null) return;

		int[] ints = intsMap.get(root);
		int tmp = Math.max(ints[0], ints[1]);
		max = Math.max(max, tmp);

		TreeNode parent = map.get(root);
		if (parent != null) {
			int[] pints = intsMap.get(parent);
			// 是左孩子
			if (parent.left == root) {
				if (pints[1] > 0)
					max = Math.max(max, tmp + pints[1]);
			} else
				if (pints[0] > 0)
					max = Math.max(max, tmp + pints[0]);
		}
		dfs1(root.left);
		dfs1(root.right);
	}
}

