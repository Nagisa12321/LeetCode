package com.leetcode.algorithm.No103;

import java.util.*;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/22 19:42
 * @version 1.0
 ************************************************/
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean isLeftStart = true;
        queue.offer(root);
        while (!queue.isEmpty()) {
            var list1 = new LinkedList<Integer>();
            int size = queue.size();
            if (isLeftStart) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    list1.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                isLeftStart = false;
            } else {
                Stack<Integer> stack = new Stack<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    stack.push(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                while (!stack.isEmpty()) {
                    list1.add(stack.pop());
                }
                isLeftStart = true;
            }
            list.add(list1);
        }
        return list;
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
