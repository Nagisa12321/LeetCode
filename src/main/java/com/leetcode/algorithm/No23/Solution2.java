package com.leetcode.algorithm.No23;

import com.leetcode.struct.ListNode;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/30 12:38
 */
public class Solution2 {
	public ListNode mergeKLists(ListNode[] lists) {
		return merge(lists, 0, lists.length - 1);
	}

	public ListNode merge(ListNode[] lists, int l, int r) {
		if (l == r) {
			return lists[l];
		}
		if (l > r) {
			return null;
		}
		int mid = (l + r) >> 1;
		FutureTask<ListNode> task1 = new FutureTask<>(() -> merge(lists, l, mid));
		FutureTask<ListNode> task2 = new FutureTask<>(() -> merge(lists, mid + 1, r));
		new Thread(task1).start();
		new Thread(task2).start();

		ListNode l1 = null, l2 = null;
		try {
			l1 = task1.get();
			l2 = task2.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return mergeTwoLists(l1, l2);
	}

	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		if (a == null || b == null) {
			return a != null ? a : b;
		}
		ListNode head = new ListNode(0);
		ListNode tail = head, aPtr = a, bPtr = b;
		while (aPtr != null && bPtr != null) {
			if (aPtr.val < bPtr.val) {
				tail.next = aPtr;
				aPtr = aPtr.next;
			} else {
				tail.next = bPtr;
				bPtr = bPtr.next;
			}
			tail = tail.next;
		}
		tail.next = (aPtr != null ? aPtr : bPtr);
		return head.next;
	}
}