package com.leetcode.binarysearchtree.No3.No2;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/7 14:49
 */
public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode cur = root;

		while (true) {
			if (cur == p || cur == q) return cur;
			else if (cur.val < p.val && cur.val < q.val) cur = cur.right;
			else if (cur.val > p.val && cur.val > q.val) cur = cur.left;
			else return cur;
		}
	}
}