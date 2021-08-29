package com.leetcode.algorithm.No217;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/13 14:18
 * @version 1.0
 ************************************************/
public class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return false;
        TreeNode tree = new TreeNode(nums[0]);
        int i = 1;
        TreeNode tmp = tree;
        while (i < nums.length) {
            if (nums[i] < tmp.val) {
                if (tmp.left == null) {
                    tmp.left = new TreeNode(nums[i]);
                    i++;
                    tmp = tree;
                } else {
                    tmp = tmp.left;
                }
            } else if (nums[i] > tmp.val) {
                if (tmp.right == null) {
                    tmp.right = new TreeNode(nums[i]);
                    i++;
                    tmp = tree;
                } else {
                    tmp = tmp.right;
                }
            } else return true;
        }
        return false;
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}

