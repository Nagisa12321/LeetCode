package com.leetcode.intermediate.No3.No5;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/15 15:06
 */
public class Solution {

    int val = 0;
    int i = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return val;
    }

    public void dfs(TreeNode root, int k) {
        if (root == null) return;

        dfs(root.left, k);
        i++;
        if (i == k) {
            val = root.val;
        }
        if (i >= k)
            return;
        dfs(root.right, k);
    }
}