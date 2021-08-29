package com.leetcode.algorithm.No109;

import com.leetcode.struct.ListNode;
import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/7 15:37
 */
public class Solution {

	private ListNode cur = null;

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		this.cur = head;

		int len = 0;
		ListNode node = head;
		while (node != null) {
			len++;
			node = node.next;
		}

		TreeNode result = createTree(len);
		dfs(result);

		return result;
	}

	// 生成一个大小为size的平衡二叉树
	private TreeNode createTree(int size) {
		if (size <= 0) return null;
		TreeNode node = new TreeNode();
		size--;
		int right = size / 2;
		int left = size - right;
		node.left = createTree(left);
		node.right = createTree(right);
		return node;
	}

	private void dfs(TreeNode node) {
		if (cur == null || node == null) return;

		dfs(node.left);
		node.val = cur.val;
		cur = cur.next;
		dfs(node.right);
	}
}