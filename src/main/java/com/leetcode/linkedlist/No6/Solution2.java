package com.leetcode.linkedlist.No6;

import com.leetcode.algorithm.No21.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2020/12/30 0:52
 */
public class Solution2 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        else if (head.next == null) return head;
        else if (k == 0) return head;

        // 遍历一次链表得长度
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }

        k %= len; // 为k求余防止越界
        int len1 = len - k; // 链表1长度

        //将链表切成两半
        tmp = head;
        for (int i = 0; i < len1 - 1; i++) tmp = tmp.next;
        ListNode head2 = tmp.next;
        tmp.next = null;

        // 让head2接head
        ListNode tmp1 = head2;
        for (int i = 0; i < k - 1; i++) tmp1 = tmp1.next;
        if (tmp1 != null) {
            tmp1.next = head;
            return head2;
        } else return head;
    }
}