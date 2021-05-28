package com.leetcode.algorithm.No1261;

import com.leetcode.struct.TreeNode;

import java.util.HashSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/14 23:27
 */
public class FindElements {

	private HashSet<Integer> set;

	public FindElements(TreeNode root) {
		set = new HashSet<>();
		calculate(root, 0);
	}

	private void calculate(TreeNode root, int val) {
		if (root == null) return ;

		set.add(val);
		root.val = val;
		calculate(root.left, val * 2 + 1);
		calculate(root.right, val * 2 + 2);
	}

	public boolean find(int target) {
		return set.contains(target);
	}
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */