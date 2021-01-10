package com.leetcode.algorithm.No21;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        ListNode node = this;
        while (node != null) {
            if (node.next != null)
            builder.append(node.val).append(", ");
            else builder.append(node.val).append("]");
            node = node.next;
        }
        return builder.toString();
    }
}