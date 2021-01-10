package com.leetcode.algorithm.No2;

import com.leetcode.algorithm.No21.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/10 15:55
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cf = 0;
        ListNode node = null;
        ListNode res = null;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (node == null) {
                    node = new ListNode((l1.val + l2.val + cf) / 10);
                    res = node;
                } else {
                    ListNode tmp = new ListNode((l1.val + l2.val + cf) / 10);
                    node.next = tmp;
                    node = node.next;
                }
                cf = (l1.val + l2.val + cf) % 10;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                if (node == null) {
                    node = new ListNode((l2.val + cf) / 10);
                    res = node;
                } else {
                    ListNode tmp = new ListNode((l2.val + cf) / 10);
                    node.next = tmp;
                    node = node.next;
                }
                cf = (l2.val + cf) % 10;
                l2 = l2.next;
            } else {
                if (node == null) {
                    node = new ListNode((l1.val + cf) / 10);
                    res = node;
                } else {
                    ListNode tmp = new ListNode((l1.val + cf) / 10);
                    node.next = tmp;
                    node = node.next;
                }
                cf = (l1.val + cf) % 10;
                l1 = l1.next;
            }
        }
        if (cf == 1) {
            ListNode tmp = new ListNode(1);
            node.next = tmp;
            node = node.next;
        }
        return res;
    }
}