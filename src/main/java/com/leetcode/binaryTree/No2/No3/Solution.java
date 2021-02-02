package com.leetcode.binaryTree.No2.No3;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/17 14:30
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return sum == root.val;
        } else if (root.left == null) {
            return hasPathSum(root.right, sum - root.val);
        } else if (root.right == null) {
            return hasPathSum(root.left, sum - root.val);
        } else {
            return hasPathSum(root.right, sum - root.val) ||
                    hasPathSum(root.left, sum - root.val);
        }
    }
}