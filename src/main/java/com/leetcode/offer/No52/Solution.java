package com.leetcode.offer.No52;

import com.leetcode.struct.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/28 16:42
 */
public class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		return getIntersectionNode(headA, headB, headA, headB);
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB, ListNode curA, ListNode curB) {
		if (curA == curB) return curA;
		else if (curA == null) {
			curA = headB;
			curB = curB.next;
		} else if (curB == null) {
			curB = headA;
			curA = curA.next;
		} else {
			curA = curA.next;
			curB = curB.next;
		}

		return getIntersectionNode(headA, headB, curA, curB);
	}
}