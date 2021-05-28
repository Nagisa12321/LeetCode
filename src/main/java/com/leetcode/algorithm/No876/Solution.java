package com.leetcode.algorithm.No876;

import com.leetcode.struct.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/7 15:21
 */
public class Solution {
	public ListNode middleNode(ListNode head) {
		int len = 0;
		ListNode node = head;
		while (node != null) {
			len++;
			node = node.next;
		}

		node = head;
		for (int i = 0; i < len / 2; i++) {
			node = node.next;
		}

		return node;
	}
}