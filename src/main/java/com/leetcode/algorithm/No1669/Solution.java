package com.leetcode.algorithm.No1669;

import com.leetcode.struct.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/7 15:27
 */
public class Solution {
	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		ListNode before_a = null;
		ListNode after_b = null;

		ListNode cur = list1;
		for (int i = 0; i < b; i++) {
			if (i == a - 1) before_a = cur;
			cur = cur.next;
		}
		after_b = cur.next;

		assert before_a != null;
		before_a.next = list2;
		while (list2.next != null) list2 = list2.next;
		list2.next = after_b;
		return list1;
	}
}