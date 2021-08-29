package com.leetcode.algorithm.No82;

import com.leetcode.struct.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/25 12:30
 */
public class Solution2 extends Solution {

	@Override
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) return null;
		else if (head.next == null) return head;

		else if (head.next.val != head.val) {
			head.next = deleteDuplicates(head.next);
			return head;
		}

		while (head.next != null && head.val == head.next.val)
			head = head.next;

		return deleteDuplicates(head.next);
	}
}
