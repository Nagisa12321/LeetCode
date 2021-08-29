package com.leetcode.algorithm.No2;


public class Main {
    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode theListNode1 = new ListNode();
        ListNode theListNode2 = new ListNode();
        ListNode theListNode1_2 = new ListNode();
        ListNode theListNode2_2 = new ListNode();
        ListNode theListNode1_3 = new ListNode();
        ListNode theListNode2_3 = new ListNode();

        theListNode1.val = 2;
        theListNode1.next = theListNode1_2;
        theListNode1_2.val = 4;
        theListNode1_2.next = theListNode1_3;
        theListNode1_3.val = 3;

        theListNode2.val = 5;
        theListNode2.next = theListNode2_2;
        theListNode2_2.val = 6;
        theListNode2_2.next = theListNode2_3;
        theListNode2_3.val = 4;


        ListNode theListNode = addTwoNumbers(theListNode1, theListNode2);
        for (ListNode iListNode = theListNode; iListNode != null; iListNode = iListNode.next) {
            System.out.println(iListNode.val);
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode theListNode = new ListNode(), tempListNode = theListNode;
        int t = 0;
        while (l1 != null || l2 != null | t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }
            //tempListNode.val = t%10;
            tempListNode.next = new ListNode();
            tempListNode = tempListNode.next;
            tempListNode.val = t % 10;
            t /= 10;
        }
        return theListNode.next;
    }
}
