package com.leetcode.offer.No26;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/11 10:50
 */
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;

        return isSame(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }


    public boolean isSame(TreeNode A, TreeNode B) {
        if (B == null) return true;
        else if (A == null || A.val != B.val) return false;

        return isSame(A.left, B.left) && isSame(A.right, B.right);
    }
}