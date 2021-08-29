package com.leetcode.offer.No25;

import com.leetcode.struct.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/18 11:07
 */
public /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        else if (l1 == null) return l2;
        else if (l2 == null) return l1;
        ListNode node = null;
        ListNode current = null;

        while (true) {
            if (l1 != null && l2 != null) {
                if (current == null) {
                    if (l1.val < l2.val) {
                        node = new ListNode(l1.val);
                        l1 = l1.next;
                    } else {
                        node = new ListNode(l2.val);
                        l2 = l2.next;
                    }
                    current = node;
                } else {
                    if (l1.val < l2.val) {
                        current.next = new ListNode(l1.val);
                        l1 = l1.next;
                    } else {
                        current.next = new ListNode(l2.val);
                        l2 = l2.next;
                    }
                    current = current.next;
                }
            } else if (l1 == null) {
                current.next = l2;
                break;
            } else {
                current.next = l1;
                break;
            }
        }

        return node;
    }
}