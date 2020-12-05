package com.leetcode.algorithm.No102;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/11/30 14:51
 * @version 1.0
 ************************************************/
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> a = new LinkedList<>();
        if (root == null) return a;
        else {
            Stack<LinkedList<Integer>> stack = new Stack<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                LinkedList<Integer> linkedList = new LinkedList<>();
                for (int i = 0; i < size; ++i) {
                    root = queue.poll();
                    if (root != null) {
                        linkedList.add(root.val);
                        queue.offer(root.left);
                        queue.offer(root.right);
                    }
                }
                if (linkedList.size() != 0)
                    stack.push(linkedList);
            }
            while (!stack.isEmpty()) {
                a.add(stack.pop());
            }
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
