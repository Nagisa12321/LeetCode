package com.leetcode.recursion.No5.No1;

import com.leetcode.struct.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/17 16:23
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        else if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else {
            ListNode first;
            if (l1.val < l2.val) {
                first = new ListNode(l1.val);
                first.next = mergeTwoLists(l1.next, l2);
            } else {
                first = new ListNode(l2.val);
                first.next = mergeTwoLists(l1, l2.next);
            }
            return first;
        }
    }
}