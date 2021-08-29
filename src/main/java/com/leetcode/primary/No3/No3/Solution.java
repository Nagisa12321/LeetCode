package com.leetcode.primary.No3.No3;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode tmp = head;
        head = head.next;
        tmp.next = null;

        while (head != null) {
            ListNode newtmp = head;
            head = head.next;
            newtmp.next = tmp;
            tmp = newtmp;
        }

        return tmp;
    }
}