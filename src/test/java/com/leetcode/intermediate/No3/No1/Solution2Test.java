package com.leetcode.intermediate.No3.No1;

import com.leetcode.struct.TreeNode;

import static org.junit.Assert.*;

public class Solution2Test {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.right = b;
        b.left = c;

        System.out.println(new Solution2().inorderTraversal(a));
    }
}