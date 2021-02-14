package com.leetcode.binarytree.No1.No3;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/16 13:41
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) return;

        dfs(root.left, list);
        dfs(root.right, list);
        list.add(root.val);
    }
}