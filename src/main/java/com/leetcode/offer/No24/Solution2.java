package com.leetcode.offer.No24;

import com.leetcode.struct.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/7 11:51
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        else if (head.next == null) return head;

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return node;
    }
}