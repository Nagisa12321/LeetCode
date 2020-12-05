package com.leetcode.primary.No4.No3;

import static org.junit.Assert.*;

public class Solution2Test {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(3);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        c.right = e;
        d.right = f;
        e.left = g;
        System.out.println(new Solution2().isSymmetric(a));
    }
}