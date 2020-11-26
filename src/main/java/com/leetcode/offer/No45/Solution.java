package com.leetcode.offer.No45;

/**
 * @链表解决
 * 可能是很笨的方法，但可行，还锻炼了一下链表的能力，不亏！
 * @执行用时： 24 ms, 在所有 Java 提交中击败了5.50%的用户
 * @内存消耗： 38.9 MB, 在所有 Java 提交中击败了7.30%的用户
 */
public class Solution {
    public String minNumber(int[] nums) {
        ListNode head = new ListNode();
        head.val = nums[0];
        for (int i = 1; i < nums.length; ++i)
            head = search(head, nums[i]);
        StringBuilder theBuilder = new StringBuilder();
        while (head != null) {
            theBuilder.append(head.val);
            head = head.next;
        }
        return theBuilder.toString();
    }

    //找到适合的位置
    private ListNode search(ListNode head, int i) {
        ListNode temp = head;
        while(compare(head.val,i)){
            if(head.next == null){
                ListNode a = new ListNode();
                a.val = i;
                head.next = a;
                return temp;
            }
            head = head.next;
        }
        ListNode a = new ListNode();
        a.val = head.val;
        a.next = head.next;
        head.next = a;
        head.val = i;
        return temp;
    }

    //若i可在num后面，则返回ture
    private boolean compare(int num, int i) {
        return (Long.parseLong(num + "" +  i) < Long.parseLong(i + "" + num));
    }
}

class ListNode {
    ListNode next;
    int val;
}
