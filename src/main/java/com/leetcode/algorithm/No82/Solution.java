package com.leetcode.algorithm.No82;

import com.leetcode.struct.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/25 12:29
 */
public /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		// ����һ���ڵ�ֵ --> ���ִ�����ӳ��
		Map<Integer, Integer> map = new HashMap<>();

		ListNode cur = head;
		while (cur != null) {
			map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
			cur = cur.next;
		}
		// ����ͷ���ظ��ڵ�֮��, �Ϳɿ��ֿ�ʼ
		while (head != null && map.get(head.val) != 1) {
			head = head.next;
		}

		if (head == null) return null;
		cur = head;

		while (cur.next != null) {
			// ���ִ�������1
			if (map.get(cur.next.val) != 1) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}

		return head;
	}
}