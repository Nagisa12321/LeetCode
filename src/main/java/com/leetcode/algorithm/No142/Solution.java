package com.leetcode.algorithm.No142;

import com.leetcode.algorithm.No21.ListNode;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/18 18:52
 * @version 1.0
 ************************************************/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode low = head;
        while (fast.next != low) {
            if (fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
            low = low.next;
        }
        low = low.next;
        fast = head;
        while (low != fast) {
            low = low.next;
            fast = fast.next;
        }
        return fast;
    }
}
