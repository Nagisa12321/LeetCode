package com.leetcode.interview.real;

public class Solution {
	/**
	 * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
	 *
	 * @param pHead1 ListNode��
	 * @param pHead2 ListNode��
	 * @param pHead3 ListNode��
	 * @return ListNode��
	 */
	public ListNode mergeThreeList (ListNode pHead1, ListNode pHead2, ListNode pHead3) {
		return mergeTwoList(mergeTwoList(pHead1, pHead2), pHead3);
	}

	private ListNode mergeTwoList(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		} else if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		else {
			if (l1.val >= l2.val) {
				l1.next = mergeTwoList(l1.next, l2);
				return l1;
			} else {
				l2.next = mergeTwoList(l1, l2.next);
				return l2;
			}
		}
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(3, new ListNode(2, new ListNode(2, new ListNode(1))));
		ListNode l2 = new ListNode(3, new ListNode(2, new ListNode(1)));
		ListNode l3 = new ListNode(6, new ListNode(3));

		Solution solution = new Solution();
		ListNode l = solution.mergeThreeList(l1, l2, l3);

		System.out.println(l);
	}
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}