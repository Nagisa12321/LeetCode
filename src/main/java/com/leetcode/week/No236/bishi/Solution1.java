package com.leetcode.week.No236.bishi;

import com.leetcode.struct.ListNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/30 10:01
 */
public class Solution1 {
	/*
	1. 编写C函数,在输入的链表中,如果存在任意两个节点的value之和为0,则将两个节点都删除(free),
		确保剩下节点中任意两两value之和都不为0,返回剩下的链表.
		typedef struct xnode{
    		int value;
    		struct xnode* next;
		} xnode;

		xnode* delete_zero_sum_nodes(xnode* list) {
    		// 你的代码 ...
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
