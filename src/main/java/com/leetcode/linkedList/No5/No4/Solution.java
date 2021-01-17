package com.leetcode.linkedList.No5.No4;

/**
 * @author jtchen
 * @version 1.0
 * @date 2020/12/29 12:31
 */
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }

    public Node(){}
};


public class Solution {
    private Node head1 = null;
    private Node node = null;

    public Node flatten(Node head) {
        dfs(head);
        return head1;
    }

    public void dfs(Node head) {
        if (head == null) return;

        //¥¶¿Ìnode
        if (node == null) {
            node = new Node();
            node.val = head.val;
            this.head1 = node;
        } else {
            Node tmp = new Node();
            tmp.val = head.val;
            tmp.prev = node;
            node.next = tmp;
            node = node.next;
        }
        //µ›πÈ±È¿˙
        dfs(head.child);
        dfs(head.next);
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

        node8.next = node9;
        node9.prev = node8;

        node9.next = node10;
        node10.prev = node9;

        node8.child = node11;
        node11.next = node12;
        node12.prev = node11;

        new Solution().flatten(node1);

    }
}