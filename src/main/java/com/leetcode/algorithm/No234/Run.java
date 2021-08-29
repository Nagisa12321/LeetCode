package com.leetcode.algorithm.No234;

public class Run {
    public static void main(String[] args){
        ListNode listNode = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(2);
//        ListNode listNode4 = new ListNode(1);
//        listNode.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
        Solution2 theSolution = new Solution2();
        System.out.println(theSolution.isPalindrome(listNode));
    }
}
