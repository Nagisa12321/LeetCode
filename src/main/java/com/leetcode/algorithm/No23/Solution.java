package com.leetcode.algorithm.No23;

import com.leetcode.struct.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/30 9:54
 */
public
class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
		for (ListNode list : lists) {
			ListNode cur = list;
			while (cur != null) {
				queue.offer(cur);
				cur = cur.next;
			}
		}

		if (queue.isEmpty())
			return null;
		ListNode head = new ListNode(queue.poll().val);
		ListNode cur = head;
		while (!queue.isEmpty()) {
			cur.next = new ListNode(queue.poll().val);
			cur = cur.next;
		}
		return head;
	}
}