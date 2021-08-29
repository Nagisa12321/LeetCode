package com.leetcode.algorithm.No81.list;

import com.leetcode.struct.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/26 15:31
 */
public class Solution2 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;

		ListNode node = head;
		while (node.next != null) {
			if (node.next.val == node.val) node.next = node.next.next;
			else node = node.next;
		}

		return head;
	}
}