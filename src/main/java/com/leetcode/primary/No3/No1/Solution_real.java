package com.leetcode.primary.No3.No1;

public class Solution_real {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
