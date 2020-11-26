package com.leetcode.primary.No3.No6;

/************************************************
 * @description ����ָ��
 * �������Ϊ���εĻ�����ô��ָ��һ����׷����ָ�룡
 * @author jtchen
 * @date 2020/11/23 13:34
 * @version 1.0
 ************************************************/
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
