package com.leetcode.linkedlist.No3.No1;

import com.leetcode.algorithm.No21.ListNode;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/23 14:09
 * @version 1.0
 ************************************************/
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(head.val);
        newHead.next = null;
        head = head.next;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = newHead;
            newHead = node;
            head = head.next;
        }
        return newHead;
    }
}
