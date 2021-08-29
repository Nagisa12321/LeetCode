package com.leetcode.offer.No54;

import static org.junit.Assert.*;

public class SolutionTest {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(4);
        TreeNode f = new TreeNode(1);
//        TreeNode g = new TreeNode(6);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        d.left = f;
//        e.left = g;
        System.out.println(new Solution().kthLargest(a,3));

    }
}