package com.leetcode.offer.No54;

/************************************************
 * @description ����һ�ö��������������ҳ����е�k��Ľڵ㡣
 * �ݹ���������ҵ����������������Ҽ�¼n
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
