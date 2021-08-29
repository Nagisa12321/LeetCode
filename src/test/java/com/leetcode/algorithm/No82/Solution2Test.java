package com.leetcode.algorithm.No82;

import com.leetcode.struct.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution2Test {

	@Test
	public void test1() {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(3);
		ListNode listNode5 = new ListNode(4);
		ListNode listNode6 = new ListNode(4);
		ListNode listNode7 = new ListNode(5);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		listNode6.next = listNode7;

		Solution2 solution = new Solution2();

		System.out.println(solution.deleteDuplicates(listNode1));
	}

}