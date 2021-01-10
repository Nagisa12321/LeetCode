package com.leetcode.LinkedList.No6;

/**
 * @author jtchen
 * @version 1.0
 * @date 2020/12/29 17:21
 */

import com.leetcode.algorithm.No21.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
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

        //分别翻转
        head = reserve(head);
        head2 = reserve(head2);

        //接起来后翻转
        tmp = head;
        while (tmp.next != null) tmp = tmp.next;
        tmp.next = head2;

        return reserve(head);

    }

    public ListNode reserve(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode tmp1  = new ListNode(head.val);
            tmp1.next = tmp;
            tmp = tmp1;
            head = head.next;
        }
        return tmp;
    }
}