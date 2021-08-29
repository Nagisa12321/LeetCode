package com.leetcode.linkedlist.No4;

import com.leetcode.algorithm.No21.ListNode;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/28 12:51
 * @version 1.0
 ************************************************/
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null
                || head.next == null
                || head.next.next == null) return head;
        ListNode node = null;
        ListNode tmp = head;
        ListNode tmp1 = null;
        while (tmp.next != null) {
            if (node == null) {
                node = new ListNode(tmp.next.val);
                tmp1 = node;
            } else {
                tmp1.next = new ListNode(tmp.next.val);
                tmp1 = tmp1.next;
            }
            if (tmp.next.next == null) {
                tmp.next = null;
            } else {
                tmp.next = tmp.next.next;
                tmp = tmp.next;
            }
        }
        tmp.next = node;
        return head;
    }
}
