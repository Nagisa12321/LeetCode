package com.leetcode.linkedlist.No3.No3;

import com.leetcode.algorithm.No21.ListNode;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/28 11:43
 * @version 1.0
 ************************************************/
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) head = head.next;
        if (head == null) return null;
        else if (head.next == null) return head;
        ListNode tmp = head;
        while (tmp != null && tmp.next != null) {
            while (tmp.next != null && tmp.next.val == val)
                tmp.next = tmp.next.next;
            tmp = tmp.next;
        }
        return head;
    }
}