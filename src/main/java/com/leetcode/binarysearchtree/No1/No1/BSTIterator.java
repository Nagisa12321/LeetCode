package com.leetcode.binarysearchtree.No1.No1;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/6 11:07
 */
public class BSTIterator {
	private final List<Integer> list;
	private final Iterator<Integer> iterator;

	public BSTIterator(TreeNode root) {
		this.list = new ArrayList<>();
		dfs(root);
		this.iterator = list.listIterator();
	}

	public void dfs(TreeNode root) {
		if (root == null) return;

		dfs(root.left);
		list.add(root.val);
		dfs(root.right);
	}

	public int next() {
		return iterator.next();
	}

	public boolean hasNext() {
		return iterator.hasNext();
	}

}

/*
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */