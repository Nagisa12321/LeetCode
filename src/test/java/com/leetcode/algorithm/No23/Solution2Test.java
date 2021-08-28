package com.leetcode.algorithm.No23;

import com.leetcode.struct.ListNode;

import static org.junit.Assert.*;

public class Solution2Test {
	public static void main(String[] args) {
		Solution2 solution2 = new Solution2();
//		solution2.mergeKLists(new ListNode[]{
//				new ListNode(1, new ListNode(4, new ListNode(5))),
//				new ListNode(1, new ListNode(3, new ListNode(4))),
//				new ListNode(2, new ListNode(6))});
		solution2.mergeKLists(new ListNode[]{
				new ListNode(1)});
	}
}