package com.leetcode.algorithm.No25;

import com.leetcode.struct.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		Solution solution = new Solution();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
//		ListNode n4 = new ListNode(4);
//		ListNode n5 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;

		System.out.println(solution.reverseKGroup(n1, 3));
	}
}