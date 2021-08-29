package com.leetcode.intermediate.No3.No1;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/11 13:04
 */



public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        var list = new ArrayList<Integer>();
        dfs(list, root);
        return list;
    }

    public void dfs(List<Integer> list, TreeNode root) {
        if (root == null) {
            // list.add(null);
            return;
        }

        dfs(list, root.left);
        list.add(root.val);
        dfs(list, root.right);
    }
}