package com.leetcode.algorithm.No1305;

import com.leetcode.struct.TreeNode;

import java.util.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/23 15:42
 */
public class Solution {
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> list = new ArrayList<>();
		dfs(root1, list);
		dfs(root2, list);

		list.sort(Comparator.comparingInt(o -> o));

		return list;
	}


	public void dfs(TreeNode root, List<Integer> list) {
		if (root == null) return;

		dfs(root.left, list);
		list.add(root.val);
		dfs(root.right, list);
	}
}