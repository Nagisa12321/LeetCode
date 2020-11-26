package com.leetcode.algorithm.No21;

public class Run {
    public static void main(String[] args){
        Solution theSolution = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(4);
        ListNode l2 = new ListNode(2);
        ListNode l2_2 = new ListNode(3);
        ListNode l2_3 = new ListNode(4);
//        l1.next = l1_2;
//        l1_2.next = l1_3;
//        l2.next = l2_2;
//        l2_2.next = l2_3;
        ListNode theNode = theSolution.mergeTwoLists(l1,l2);
        while (theNode != null){
            System.out.println(theNode.val);
            theNode = theNode.next;
        }

    }
}
