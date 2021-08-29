package com.leetcode.linkedlist.No2.No4;

import com.leetcode.algorithm.No21.ListNode;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/23 13:54
 * @version 1.0
 ************************************************/
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        while (tmpA != tmpB) {
            tmpA = tmpA == null ? headB : tmpA.next;
            tmpB = tmpB == null ? headA : tmpB.next;
        }
        return tmpA;
    }
}
