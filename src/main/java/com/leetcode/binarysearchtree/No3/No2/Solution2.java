package com.leetcode.binarysearchtree.No3.No2;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/7 15:09
 */
public class Solution2 extends Solution {
	@Override
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == p || root == q) return root;
		else if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
		else if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
		else return root;
	}
}
