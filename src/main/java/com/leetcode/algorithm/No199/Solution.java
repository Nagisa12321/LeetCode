package com.leetcode.algorithm.No199;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/8 19:09
 */
class Solution {
	public List<Integer> rightSideView(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		if (root == null) return list;
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();

				if (i == size - 1)
					list.add(node.val);
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
		}

		return list;
	}
}