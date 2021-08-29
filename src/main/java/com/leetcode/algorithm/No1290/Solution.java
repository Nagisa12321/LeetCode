package com.leetcode.algorithm.No1290;

import com.leetcode.struct.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/7 15:18
 */
public class Solution {
	public int getDecimalValue(ListNode head) {
		int result = 0;
		ListNode node = head;
		while (node != null) {
			result <<= 1;
			result += node.val;
			node = node.next;
		}

		return result;
	}
}