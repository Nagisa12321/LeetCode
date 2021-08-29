package com.leetcode.primary.No4.No2;

/************************************************
 * @description 递归中序遍历
 * @author jtchen
 * @date 2020/11/25 17:42
 * @version 1.0
 ************************************************/
public class Solution3 {
    long minValue = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(!isValidBST(root.left))return false;
        if(root.val <= minValue) return false;
        minValue = root.val;
        return isValidBST(root.right);
    }

//    public void Traverse(TreeNode root){
//        if(root == null) return;
//        TreeNode
//    }
}
