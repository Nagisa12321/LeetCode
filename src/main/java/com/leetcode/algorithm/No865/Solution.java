package com.leetcode.algorithm.No865;

import com.leetcode.struct.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/10 14:26
 */
public class Solution {
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if (root == null) return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		List<TreeNode> last = new LinkedList<>();
		while (!queue.isEmpty()) {
			last.clear();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				last.add(node);

				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
		}

		return getDeepestParent(last, root);
	}

	private TreeNode getDeepestParent(List<TreeNode> list, TreeNode root) {
		if (list.size() == 1) return list.get(0);

		while (list.size() > 1) {
			TreeNode node1 = list.get(0);
			TreeNode node2 = list.get(1);
			list.remove(0);
			list.remove(0);

			TreeNode parent = getDeepestParent(root, node1, node2);
			list.add(parent);
		}

		return list.get(0);
	}

	private TreeNode getDeepestParent(TreeNode root, TreeNode nodeA, TreeNode nodeB) {
		if (root == null) return null;
		if (root == nodeA || root == nodeB) return root;

		TreeNode left = getDeepestParent(root.left, nodeA, nodeB);
		TreeNode right = getDeepestParent(root.right, nodeA, nodeB);

		if (left != null && right != null) return root;
		if (left != null) return left;
		else return right;
	}
}