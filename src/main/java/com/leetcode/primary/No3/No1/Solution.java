package com.leetcode.primary.No3.No1;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                if (tmp.next.next == null) {
                    tmp.next = null;
                    break;
                }
                else tmp.next = tmp.next.next;
            }
            tmp = tmp.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}