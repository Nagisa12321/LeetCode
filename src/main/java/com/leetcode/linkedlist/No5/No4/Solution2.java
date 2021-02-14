package com.leetcode.linkedlist.No5.No4;

import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2020/12/29 13:18
 */
public class Solution2 {
    public Node flatten(Node head) {
        // if (head == null) return null;
        var stack = new Stack<Node>();
        Node node = null;
        Node head1 = null;
        while (head != null || !stack.isEmpty()) {
            // head为空直接从栈中取元素作为head的前身
            while (head == null && !stack.isEmpty())
                head = stack.pop().next;
            if (head == null) break;
            // 处理节点
            if (node == null) {
                node = new Node();
                node.val = head.val;
                head1 = node;
            } else {
                Node tmp = new Node();
                tmp.val = head.val;
                tmp.prev = node;
                node.next = tmp;
                node = node.next;
            }

            // 栈模拟递归
            if (head.child != null) {
                stack.push(head);
                head = head.child;
            } else head = head.next;

        }
        return head1;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);

        node1.next = node2;
        node2.prev = node1;

        node2.next = node3;
        node3.prev = node2;

        node3.next = node4;
        node4.prev = node3;

        node4.next = node5;
        node5.prev = node4;

        node5.next = node6;
        node6.prev = node5;

        node3.child = node7;
        node7.next = node8;
        node8.prev = node7;

        /*node8.next = node9;
        node9.prev = node8;

        node9.next = node10;
        node10.prev = node9;*/

        node8.child = node11;
        node11.next = node12;
        node12.prev = node11;

        new Solution2().flatten(node1);

    }
}