package com.leetcode.primary.No4.No2;

/************************************************
 * @description 牛逼的递归！
 * @author jtchen
 * @date 2020/11/25 17:09
 * @version 1.0
 ************************************************/
public class Solution2 {
    public boolean isValidBST(TreeNode root, long min, long max){
        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;

        else return isValidBST(root.left,min,root.val) &&
                isValidBST(root.right,root.val,max);
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }
}
