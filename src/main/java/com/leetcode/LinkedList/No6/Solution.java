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
        // ����һ������ó���
        int len = 0;
        ListNode tmp = head;
        while (tmp != null) {
            len++;
            tmp = tmp.next;
        }

        k %= len; // Ϊk�����ֹԽ��
        int len1 = len - k; // ����1����

        //�������г�����
        tmp = head;
        for (int i = 0; i < len1 - 1; i++) tmp = tmp.next;
        ListNode head2 = tmp.next;
        tmp.next = null;

        //�ֱ�ת
        head = reserve(head);
        head2 = reserve(head2);

        //��������ת
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