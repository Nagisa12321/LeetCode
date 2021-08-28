package com.leetcode.algorithm.No987;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/31 10:04
 */
public class Solution {
	private int less = 0;
	private int high = 0;
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		HashMap<Integer, List<TreeNode>> map = new HashMap<>();
		HashMap<TreeNode, Integer> floorMap = new HashMap<>();

		dfs(root, map, 0, floorMap, 0);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = less; i <= high; i++) {
			List<TreeNode> list = map.get(i);
			list.sort((t1, t2) -> {
				int f1 = floorMap.get(t1);
				int f2 = floorMap.get(t2);
				if (f1 != f2)
					return f1 - f2;
				return t1.val - t2.val;
			});
			List<Integer> tmp = new ArrayList<>();
			for (TreeNode node : list) {
				tmp.add(node.val);
			}
			res.add(tmp);
		}
		return res;
	}

	private void dfs(TreeNode node,
					 HashMap<Integer, List<TreeNode>> map,
					 int row,
					 HashMap<TreeNode, Integer> floorMap,
					 int floor) {
		if (node == null)
			return;
		if (!map.containsKey(row))
			map.put(row, new ArrayList<>());
		if (row < less)
			less = row;
		if (row > high)
			high = row;
		map.get(row).add(node);
		floorMap.put(node, floor);
		dfs(node.left, map, row - 1, floorMap, floor + 1);
		dfs(node.right, map, row + 1, floorMap, floor + 1);
	}
}