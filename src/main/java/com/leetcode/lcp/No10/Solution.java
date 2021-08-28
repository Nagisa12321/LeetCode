package com.leetcode.lcp.No10;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/22 17:48
 */

import com.leetcode.struct.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	static class DoubleTreeNode {
		double val;

		DoubleTreeNode left;
		DoubleTreeNode right;

		public DoubleTreeNode(double val) {
			this.val = val;
		}

		public String toString() {
			return Double.toString(val);
		}
	}

	public DoubleTreeNode copyTree(TreeNode root) {
		if (root == null) return null;
		DoubleTreeNode res = new DoubleTreeNode(root.val);
		res.left = copyTree(root.left);
		res.right = copyTree(root.right);
		return res;
	}
	public double minimalExecTime(TreeNode root) {
		DoubleTreeNode realTree = copyTree(root);
		PriorityQueue<DoubleTreeNode> pq =
				new PriorityQueue<>(Comparator.comparingDouble(node -> node.val));
		pq.offer(realTree);
		double time = 0;
		while (!pq.isEmpty()) {
			DoubleTreeNode nowRunning = pq.poll();

			// 一起run的节点
			DoubleTreeNode run1 = null;
			DoubleTreeNode run2 = null;
			if (!pq.isEmpty())
				run1 = pq.poll();
			if (!pq.isEmpty())
				run2 = pq.poll();

			if (run1 == null && run2 == null) {
				time += nowRunning.val;
			} else if (run1 != null && run2 == null) {
				run1.val -= nowRunning.val;
				time += nowRunning.val;
				pq.offer(run1);
			} else if (run1 != null) {
				time += nowRunning.val;
				double abs = run2.val - run1.val;
				if (abs < nowRunning.val) {
					double leave = (run1.val + run2.val - nowRunning.val) / 2;
					run1.val = leave;
					run2.val = leave;
				} else {
					run1.val -= nowRunning.val;
				}
				pq.offer(run1);
				pq.offer(run2);
			}
			if (nowRunning.left != null)
				pq.offer(nowRunning.left);
			if (nowRunning.right != null)
				pq.offer(nowRunning.right);
		}
		return time;
	}
}