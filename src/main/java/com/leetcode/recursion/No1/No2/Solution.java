package com.leetcode.recursion.No1.No2;

import com.leetcode.struct.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/16 15:38
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // ¸¨ÖúÍ·²¿
        var tmp = new ListNode();
        tmp.next = head;
        swap(tmp);

        return tmp.next;
    }

    public void swap(ListNode node) {
        if (node.next == null || node.next.next == null) return;

        swap(node.next.next);
        var tmp1 = node.next;
        var tmp2 = node.next.next.next;
        node.next = tmp1.next;
        node.next.next = tmp1;
        node.next.next.next = tmp2;
    }
}