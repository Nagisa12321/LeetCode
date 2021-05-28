package com.leetcode.algorithm.No25;

import com.leetcode.struct.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/8 15:30
 */
public class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		// 先截取能翻转的部分. 保存之后不翻转的部分
		int len = 0;
		ListNode cur = head;
		while (cur != null) {
			len++;
			cur = cur.next;
		}

		len -= len % k;
		ListNode right = null; // 剩下的部分
		cur = head;
		for (int i = 0; i < len - 1; i++) {
			cur = cur.next;
		}
		right = cur.next;
		cur.next = null;

		ListNode left = reverseKGroup(head, k, k);
		return left;
	}

	public ListNode reverseKGroup(ListNode head, int k, int now) {
		if (head == null) return null;
		else if (now == 1) {
			head.next = reverseKGroup(head.next, k, k);
			return head;
		} else {
			ListNode tmp = reverseKGroup(head.next, k, now - 1);
			ListNode nextCur = tmp.next;
			tmp.next = head;
			head.next = nextCur;
			return tmp;
		}
	}
}