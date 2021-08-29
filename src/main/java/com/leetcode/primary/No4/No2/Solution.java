package com.leetcode.primary.No4.No2;

import java.util.Stack;

/************************************************
 * @description 中序遍历的方法，并且用栈记录遍历结果，以便
 * 判断
 * @author jtchen
 * @date 2020/11/25 17:07
 * @version 1.0
 ************************************************/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<Integer> num = new Stack<>();
        int index = 0;
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        root = root.left;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (num.isEmpty()) {
                    num.push(root.val);
                } else {
                    if (root.val <= num.peek()) return false;
                    else {
                        num.push(root.val);
                    }
                }
                root = root.right;
            }
        }
        return true;
    }
}
