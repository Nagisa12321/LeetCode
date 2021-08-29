package com.leetcode.hashmap.No4.No2;

import com.leetcode.struct.TreeNode;

import static org.junit.Assert.*;

public class Solution2Test {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(0);
        TreeNode node8 = new TreeNode(0);
        TreeNode node9 = new TreeNode(0);
        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node3.right = node5;
        node4.left = node6;
        node4.right = node7;
        node5.left = node8;
        node5.right = node9;

        System.out.println(new Solution2().findDuplicateSubtrees(node1));
    }
}