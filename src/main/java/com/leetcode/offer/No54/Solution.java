package com.leetcode.offer.No54;

/************************************************
 * @description 给定一棵二叉搜索树，请找出其中第k大的节点。
 * 递归遍历，从右到左的中序遍历，并且记录n
 * @author jtchen
 * @date 2020/11/28 18:57
 * @version 1.0
 ************************************************/
public class Solution {
    int node;
    int i = 1;
    public int kthLargest(TreeNode root, int k) {
        travel(root,k+1);
        return node;
    }

    public void travel(TreeNode root,int k){
        if(root != null){
            travel(root.right,k);
            i++;
            if(i == k) {
                node = root.val;
                i = Integer.MIN_VALUE;
                return;
            }
            travel(root.left,k);
        }
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
