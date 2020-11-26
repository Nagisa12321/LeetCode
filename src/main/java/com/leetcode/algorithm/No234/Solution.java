package com.leetcode.algorithm.No234;

import java.util.Stack;

/**
 * @˼·�� ���������һ�Σ����洢��ջ�У�˳�����������
 *        Ȼ�����һ������������ֲ�ֱͬ�����false����
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
