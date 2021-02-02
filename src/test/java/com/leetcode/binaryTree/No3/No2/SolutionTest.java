package com.leetcode.binaryTree.No3.No2;

public class SolutionTest {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        System.out.println(new Solution().buildTree(preorder, inorder));
    }
}