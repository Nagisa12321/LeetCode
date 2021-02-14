package com.leetcode.offer.No68.tree;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/14 10:38
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        else if (left != null) return left;
        else return right;
    }
}