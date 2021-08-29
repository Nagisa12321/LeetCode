package com.leetcode.algorithm.No110;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/10 14:33
 */
public class Solution {
	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;

		HashMap<TreeNode, Integer> map = new HashMap<>();
		ArrayList<TreeNode> list = new ArrayList<>();
		dfs(root, list);

		for (TreeNode node : list) {
			int left = maxDeep(node.left, map);
			int right = maxDeep(node.right, map);

			if (Math.abs(left - right) > 1) return false;
		}
		return true;
	}

	public void dfs(TreeNode node, List<TreeNode> list) {
		if (node == null) return;

		list.add(node);
		dfs(node.left, list);
		dfs(node.right, list);
	}

	public int maxDeep(TreeNode root, Map<TreeNode, Integer> map) {
		if (root == null) return 0;

		if (map.containsKey(root)) return map.get(root) + 1;

		int left = maxDeep(root.left, map);
		int right = maxDeep(root.right, map);


		int max = Math.max(left, right);
		map.put(root, max);

		return max + 1;
	}
}