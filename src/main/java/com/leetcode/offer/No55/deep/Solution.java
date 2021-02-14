package com.leetcode.offer.No55.deep;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/13 22:37
 */
public class Solution {
    private int max = 0;

    public int maxDepth(TreeNode root) {
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