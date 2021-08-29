package com.leetcode.binarysearchtree.No1.No1;

import com.leetcode.struct.TreeNode;

import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/6 11:25
 */
public class BSTIterator1 {
	private final Stack<TreeNode> stack;
	private TreeNode tmp;

	public BSTIterator1(TreeNode root) {
		stack = new Stack<>();
		tmp = root;
	}

	public int next() {
		while (tmp != null) {
			stack.push(tmp);
			tmp = tmp.left;
		}
		tmp = stack.pop();
		// System.out.println(tmp.val);
		int val = tmp.val;
		tmp = tmp.right;

		return val;
	}

	public boolean hasNext() {
		return !stack.isEmpty() || tmp != null;
	}
}
