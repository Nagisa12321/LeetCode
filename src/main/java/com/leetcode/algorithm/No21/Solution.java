package com.leetcode.algorithm.No21;

/**
 * 类似于双指针的想法：遍历第一个链表，把第二个插在其间
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else if (l1.val <= l2.val) return mergeTwoLists_chance(l1, l2);
        else return mergeTwoLists_chance(l2, l1);
    }

    public ListNode mergeTwoLists_chance(ListNode l1, ListNode l2) {
        //l1为主链表，并且为l1创建一个可以遍历的副本~
        ListNode head = l1;
        //遍历l1
        while (head != null) {
            //如果l2节点的值大于head节点的值
            if (l2.val >= head.val) {
                //如果head节点已经走到尽头
                if (head.next == null) {
                    //把l2节点加入l1中并且更新head
                    ListNode newNode = new ListNode(l2.val);
                    head.next = newNode;
                    head = head.next;
                } else if (l2.val <= head.next.val) {
                    //head->head.next    newNode
                    ListNode newNode = new ListNode(l2.val);
                    //head.next(temp)
                    ListNode temp = head.next;
                    //head->newNode
                    head.next = newNode;
                    //head->newNode->temp
                    newNode.next = temp;
                    //oldHead->head->head.next
                    head = newNode;
                } else {
                    head = head.next;
                    continue;
                }
                if (l2.next != null)
                    l2 = l2.next;
                else break;
            }
        }
        return l1;
    }
}
