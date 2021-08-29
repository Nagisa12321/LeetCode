package com.leetcode.algorithm.No113;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/8 18:20
 */
public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> res = new ArrayList<>();
		track(root, res, new Stack<>(), targetSum);
		return res;
	}

	public void track(TreeNode root, List<List<Integer>> res, Stack<Integer> stack, int targetSum) {
		if (root == null) return;
		else if (root.val == targetSum && root.left == null && root.right == null) {
			stack.push(targetSum);
			res.add(new ArrayList<>(stack));
			stack.pop();
		}

		int val = root.val;
		stack.push(val);
		track(root.left, res, stack, targetSum - val);
		stack.pop();

		stack.push(val);
		track(root.right, res, stack, targetSum - val);
		stack.pop();
	}
}