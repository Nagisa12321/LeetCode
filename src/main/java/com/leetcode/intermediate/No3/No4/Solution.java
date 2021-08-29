package com.leetcode.intermediate.No3.No4;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/15 13:29
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        connectTwo(root.left, root.right);
        return root;
    }

    public void connectTwo(Node left, Node right) {
        if (left == null) return;

        Node tmpL = left, tmpR = right;
        while (tmpL != null) {
            tmpL.next = tmpR;
            tmpL = tmpL.right;
            tmpR = tmpR.left;
        }

        connectTwo(left.left, left.right);
        connectTwo(right.left, right.right);
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
};
