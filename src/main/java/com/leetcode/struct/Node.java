package com.leetcode.struct;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/12 9:57
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    @Override
    public String toString() {
        return "Node[" + "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ']';
    }
};