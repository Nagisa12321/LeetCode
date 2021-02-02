package com.leetcode.binaryTree.No2.No2;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/17 14:14
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) return true;
        else if (leftTree == null) return false;
        else if (rightTree == null) return false;
        else if (leftTree.val != rightTree.val) return false;
        else
            return isSymmetric(leftTree.left, rightTree.right) &&
                    isSymmetric(leftTree.right, rightTree.left);
    }
}