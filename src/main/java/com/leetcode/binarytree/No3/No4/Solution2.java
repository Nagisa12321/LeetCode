package com.leetcode.binarytree.No3.No4;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/3 9:42
 */
public class Solution2 {
    public Node connect(Node root) {
        if (root == null) return null;

        Node start = root;
        while (start != null) {
            Node nextStart = null;

            Node current = start;
            Node last = null;
            while (current != null) {
                if (current.left != null && current.right != null) {
                    if (nextStart == null) nextStart = current.left;
                    current.left.next = current.right;
                    if (last != null) {
                        last.next = current.left;
                        last = last.next.next;
                    } else {
                        last = current.right;
                    }
                } else if (current.left == null && current.right != null) {
                    if (nextStart == null) nextStart = current.right;
                    if (last != null) {
                        last.next = current.right;
                        last = last.next;
                    } else {
                        last = current.right;
                    }
                } else if (current.left != null) {
                    if (nextStart == null) nextStart = current.left;
                    if (last != null) {
                        last.next = current.left;
                        last = last.next;
                    } else {
                        last = current.left;
                    }
                }
                current = current.next;
            }
            start = nextStart;
        }

        return root;
    }
}