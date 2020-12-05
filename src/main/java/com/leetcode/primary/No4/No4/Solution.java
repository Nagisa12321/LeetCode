package com.leetcode.primary.No4.No4;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

/************************************************
 * @description 给你一个二叉树，请你返回其按 层序遍历
 * 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * @author jtchen
 * @date 2020/11/27 23:15
 * @version 1.0
 ************************************************/
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> a = new LinkedList<>();
        if (root == null) return a;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> b = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                root = queue.poll();
                if (root != null) {
                    b.add(root.val);
                    queue.offer(root.left);
                    queue.offer(root.right);
                }
            }
            if (b.size() != 0)
                a.add(b);
        }
        return a;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
    TreeNode() {
    }
}


