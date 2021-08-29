package com.leetcode.intermediate.No3.No1;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/11 13:06
 */
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        var list = new ArrayList<Integer>();
        if (root == null) return list;
        var stack = new Stack<TreeNode>();
        stack.push(root);
        root = root.left;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}