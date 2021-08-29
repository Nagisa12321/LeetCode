package com.leetcode.offer.No27;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/12 0:55
 */
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;

        mirror(root);

        return root;
    }

    public void mirror(TreeNode root) {
        if (root == null) return;

        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        mirror(root.left);
        mirror(root.right);
    }
}