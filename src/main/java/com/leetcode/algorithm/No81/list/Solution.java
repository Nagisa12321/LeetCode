package com.leetcode.algorithm.No81.list;

import com.leetcode.struct.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/26 15:19
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;
		while (head.next != null && head.val == head.next.val)
			head = head.next;

		head.next = deleteDuplicates(head.next);
		return head;	}
}