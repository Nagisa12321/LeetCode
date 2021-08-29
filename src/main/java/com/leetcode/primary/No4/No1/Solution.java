package com.leetcode.primary.No4.No1;


/************************************************
 * @description
 * @author jtchen
 * @date 2020/11/24 12:23
 * @version 1.0
 ************************************************/
public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
//        TreeNode f = new TreeNode(6);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
//        c.left = f;
        System.out.println(new Solution().maxDepth(a));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}