package com.leetcode.algorithm.No234;

import java.util.Stack;

/**
 * @思路： 通过快慢指针找到中间节点
 * @Stack方法翻转 只会比第一种方法更慢
 * @重构链表方法
 */
public class Solution2 {
    public boolean isPalindrome(ListNode head) {
        ListNode fastPointer = head, slowPointer = head;
        //经过此循环，可以确定slowPointer为中间节点
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        //如果fast不为空，说明链表的长度是奇数个
        if (fastPointer != null) {
            slowPointer = slowPointer.next;
        }
        //翻转后半部分链表
        slowPointer = reverse(slowPointer);
        fastPointer = head;
        while (slowPointer != null) {
            if (fastPointer.val != slowPointer.val)
                return false;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        return true;
    }

    //通过Stack反转链表
//    public ListNode reverse(ListNode head) {
//        Stack<Integer> theStack = new Stack<>();
//        while (head != null) {
//            theStack.push(head.val);
//            head = head.next;
//        }
//        if (!theStack.isEmpty()) {
//            ListNode newList = new ListNode(theStack.pop());
//            ListNode tempList = newList;
//            while (!theStack.isEmpty()) {
//                ListNode a = new ListNode(theStack.pop());
//                newList.next = a;
//                newList = newList.next;
//            }
//            return tempList;
//        } else return null;
//    }
    public ListNode reverse(ListNode head) {
        if(head == null)
            return  null;
        ListNode newList = new ListNode(head.val);
//        ListNode returnList = newList;
        while (head.next != null){
            head = head.next;
            ListNode temp = new ListNode(head.val);
            ListNode oldList = newList;
            newList = temp;
            newList.next = oldList;
        }
        return newList;
    }
}
