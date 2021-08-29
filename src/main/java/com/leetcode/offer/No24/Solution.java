package com.leetcode.offer.No24;

import com.leetcode.struct.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/7 11:51
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode tmp = head;
        head = head.next;
        tmp.next = null;

        while (head != null) {
            ListNode newTmp = head;
            head = head.next;
            newTmp.next = tmp;
            tmp = newTmp;
        }

        return tmp;
    }
}