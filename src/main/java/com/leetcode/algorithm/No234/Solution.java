package com.leetcode.algorithm.No234;

import java.util.Stack;

/**
 * @思路： 将链表遍历一次，并存储在栈中，顺便计算链表长度
 *        然后遍历一半的链表，若出现不同直接输出false即可
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> theStack = new Stack<>();
        ListNode tempHead = head;
        int length = 0;
        while (tempHead != null) {
            theStack.push(tempHead.val);
            tempHead = tempHead.next;
            length++;
        }
        for (int i = 0; i < length / 2; i++) {
            if (theStack.pop() != head.val)
                return false;
            head = head.next;
        }
        return true;
    }
}
