package com.leetcode.primary.No3.No2;

class ListNode {
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

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode tmp = head;
        if (n > 1) {
            while (true) {
                ListNode tmp2 = tmp;
                for (int i = 0; i < n; ++i)
                    tmp2 = tmp2.next;
                if (tmp2 == null) {
                    tmp.val = tmp.next.val;
                    tmp.next = tmp.next.next;
                    break;
                }
                tmp = tmp.next;
            }
        } else {
            while (true) {
                if(tmp.next == null) return null;
                else if (tmp.next.next == null) {
                    tmp.next = null;
                    break;
                }
                tmp = tmp.next;
            }
        }
        return head;
    }
}