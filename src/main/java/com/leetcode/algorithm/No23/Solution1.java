package com.leetcode.algorithm.No23;

import com.leetcode.struct.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/30 12:38
 */
public class Solution1 {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		for (int i = 1; i < lists.length; i++) {
			lists[0] = merge(lists[0], lists[i]);
		}
		return lists[0];
	}

	public ListNode merge(ListNode list1, ListNode list2) {
		ListNode newList = null;
		ListNode cur = null;
		while (list1 != null || list2 != null) {
			if (list1 == null) {
				if (newList == null) {
					return list2;
				} else {
					cur.next = list2;
					return newList;
				}
			} else if (list2 == null) {
				if (newList == null) {
					return list1;
				} else {
					cur.next = list1;
					return newList;
				}
			} else {
				if (newList == null) {
					if (list1.val <= list2.val) {
						newList = new ListNode(list1.val);
						list1 = list1.next;
					} else {
						newList = new ListNode(list2.val);
						list2 = list2.next;
					}
					cur = newList;
				} else {
					ListNode newNode;
					if (list1.val <= list2.val) {
						newNode = new ListNode(list1.val);
						list1 = list1.next;
					} else {
						newNode = new ListNode(list2.val);
						list2 = list2.next;
					}
					cur.next = newNode;
					cur = cur.next;
				}
			}
		}
		return null;
	}
}