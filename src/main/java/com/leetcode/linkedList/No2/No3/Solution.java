package com.leetcode.linkedList.No2.No3;

import com.leetcode.algorithm.No21.ListNode;

import java.util.HashSet;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/18 15:52
 * @version 1.0
 ************************************************/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        var set = new HashSet<ListNode>();
        while (head != null) {
            if (!set.add(head)) return head;
            else head = head.next;
        }
        return null;
    }
}
