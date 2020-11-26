package com.leetcode.primary.No4.No3;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/11/26 11:48
 * @version 1.0
 ************************************************/
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left,root.right);
    }
    public boolean isSymmetric(TreeNode theLeft, TreeNode theRight) {
        if(theLeft == null && theRight == null) return true;
        if(theLeft == null && theRight != null) return false;
        if(theLeft != null && theRight == null) return false;
        if(theRight.val != theLeft.val) return false;
        return (isSymmetric(theLeft.left,theRight.right))
                && (isSymmetric(theLeft.right,theRight.left));
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
