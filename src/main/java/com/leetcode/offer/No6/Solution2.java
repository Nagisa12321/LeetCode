package com.leetcode.offer.No6;

import com.leetcode.struct.ListNode;

import java.util.ArrayList;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/7 11:38
 */
public class Solution2 {
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int len = list.size();
        int[] ints = new int[len];
        for (int i = 0; i < len; i++)
            ints[i] = list.get(len - i - 1);

        return ints;
    }
}