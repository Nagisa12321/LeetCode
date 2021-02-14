package com.leetcode.linkedlist.No2.No4;

import com.leetcode.algorithm.No21.ListNode;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/23 13:49
 * @version 1.0
 ************************************************/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        //遍历A, 得到A得长度
        int lenA = 0;
        ListNode tmp = headA;
        while (tmp != null) {
            lenA++;
            tmp = tmp.next;
        }
        //遍历B, 得到B的长度
        int lenB = 0;
        tmp = headB;
        while (tmp != null) {
            lenB++;
            tmp = tmp.next;
        }
        //A, B同一终点遍历
        if (lenA > lenB) {
            int tmp1 = lenA - lenB;
            for (int i = 0; i < tmp1; i++) headA = headA.next;
        } else if (lenA < lenB) {
            int tmp1 = lenB - lenA;
            for (int i = 0; i < tmp1; i++) headB = headB.next;
        }
        while (headA != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
