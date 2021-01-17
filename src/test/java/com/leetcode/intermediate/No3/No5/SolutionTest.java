package com.leetcode.intermediate.No3.No5;

import com.leetcode.struct.TreeNode;

public class SolutionTest {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(4);

        a.left = b;
        b.right = c;
        a.right = d;

        System.out.println(new Solution().kthSmallest(a, 1));

    }
}