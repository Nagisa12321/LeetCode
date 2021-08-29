package com.leetcode.algorithm.No1382;

import com.leetcode.struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/13 17:58
 */
public class Solution {
	private int len = 0;
	private Queue<Integer> nodes = new LinkedList<>();
	public TreeNode balanceBST(TreeNode root) {
		// 计算出结果集合, 方便填入结果树中
		// 计算出节点数, 创建空的结果
		dfs(root);
		TreeNode res = createBalanceBST(len);
		dfs_set(res);
		return res;
	}

	private void dfs(TreeNode root) {
		if (root == null) return;

		dfs(root.left);
		len++;
		nodes.offer(root.val);
		dfs(root.right);
	}

	private void dfs_set(TreeNode root) {
		if (root == null) return;

		dfs_set(root.left);
		root.val = nodes.poll();
		dfs_set(root.right);
	}

	private TreeNode createBalanceBST(int len) {
		if (len == 0) return null;
		else if (len == 1) return new TreeNode();
		else {
			TreeNode res = new TreeNode();
			int left = (len - 1) / 2;
			int right = len - 1 - left;
			res.left = createBalanceBST(left);
			res.right = createBalanceBST(right);
			return res;
		}
	}
}