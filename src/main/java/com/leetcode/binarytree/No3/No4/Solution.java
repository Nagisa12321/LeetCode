package com.leetcode.binarytree.No3.No4;

import java.util.LinkedList;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/3 9:18
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        Node node = root;
        var queue = new LinkedList<Node>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Node last = null;
            for (int i = 0; i < size; i++) {
                var tmp = queue.poll();

                if (last != null) {
                    last.next = tmp;
                    last = last.next;
                } else {
                    last = tmp;
                }

                if (tmp.left != null) queue.offer(tmp.left);
                if (tmp.right != null) queue.offer(tmp.right);
            }
        }

        return node;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
};
