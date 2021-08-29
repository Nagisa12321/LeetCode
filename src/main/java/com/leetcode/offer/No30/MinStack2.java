package com.leetcode.offer.No30;

/**
 * 链表实现
 */
public class MinStack2 {
    private ListNode head;

    public MinStack2() {
        head = new ListNode();
    }

    public void push(int x) {
        ListNode a = new ListNode();
        a.val = x;
        if (head.next != null)
            a.min = Math.min(head.min, a.val);
        else a.min = a.val;
        a.next = head;
        head = a;
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int min() {
        return head.min;
    }
}

class ListNode {
    public ListNode next;
    public int val;
    public int min;
}