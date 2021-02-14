package com.leetcode.offer.No6;

import com.leetcode.struct.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/7 11:31
 */
public class Solution {
    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        help(head, list);

        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ints[i] = list.get(i);

        return ints;
    }

    public void help(ListNode node, List<Integer> list) {
        if (node == null) return;

        help(node.next, list);

        list.add(node.val);
    }
}