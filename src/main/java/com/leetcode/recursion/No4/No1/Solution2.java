package com.leetcode.recursion.No4.No1;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/17 12:59
 */
public class Solution2 {
    int max = 0;

    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return max;
    }

    public void dfs(TreeNode root, int deep) {
        if (root == null) return;

        if (deep > max) max = deep;

        dfs(root.left, deep + 1);
        dfs(root.right, deep + 1);
    }
}