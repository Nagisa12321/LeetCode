package com.leetcode.week.No236.bishi;

import com.leetcode.struct.ListNode;
import org.junit.Test;

public class SolutionTest {

	@Test
	public void delete_zero_sum_nodes() {

		ListNode node1 = new ListNode(-1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(-3);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(4);
		ListNode node7= new ListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;

		Solution1 solution = new Solution1();

		ListNode listNode = solution.delete_zero_sum_nodes(node1);

		ListNode tmp = listNode;
		while (tmp.next != null) {
			System.out.println(tmp);
		}
	}
}