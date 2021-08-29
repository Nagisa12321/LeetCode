package com.leetcode.week.No236.bishi;

import com.leetcode.struct.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/30 10:01
 */
public class Solution1 {
	/*
	1. ��дC����,�������������,����������������ڵ��value֮��Ϊ0,�������ڵ㶼ɾ��(free),
		ȷ��ʣ�½ڵ�����������value֮�Ͷ���Ϊ0,����ʣ�µ�����.
		typedef struct xnode{
    		int value;
    		struct xnode* next;
		} xnode;

		xnode* delete_zero_sum_nodes(xnode* list) {
    		// ��Ĵ��� ...
		}
	 */

	public ListNode delete_zero_sum_nodes(ListNode node) {
		if (node == null) return null;
		else if (node.next == null) return node;
		else if (node.val + node.next.val == 0) return delete_zero_sum_nodes(node.next.next);
		node.next = delete_zero_sum_nodes(node.next);
		return node;
	}
}
