package com.leetcode.algorithm.No103;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    public static void main(String[] args) {
        TreeNode tree3 = new TreeNode(3);
        TreeNode tree9 = new TreeNode(9);
        TreeNode tree20 = new TreeNode(20);
        TreeNode tree15 = new TreeNode(15);
        TreeNode tree7 = new TreeNode(7);
        tree3.left = tree9;
        tree3.right = tree20;
        tree20.left = tree15;
        tree20.right = tree7;
        System.out.println(Arrays.toString(new Solution().zigzagLevelOrder(tree3).toArray()));
    }
}