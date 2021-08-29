package com.leetcode.offer.No55.balance;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/14 10:18
 */
public class Solution {

    private int max = 0;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        max = 0;
        dfs(root, 1);
        return max;
    }

    public void dfs(TreeNode root, int deep) {
        if (root == null) return;

        max = Math.max(deep, max);
        dfs(root.left, deep + 1);
        dfs(root.right, deep + 1);
    }
}