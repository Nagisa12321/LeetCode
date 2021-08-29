package com.leetcode.algorithm.No222;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/14 11:30
 */
public class Solution {
	public int countNodes(TreeNode root) {
		return root == null ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
	}
}