package com.leetcode.primary.No3.No6;

import java.util.HashMap;

/************************************************
 * @description ����һ�������ж��������Ƿ��л���
 * �����������ĳ���ڵ㣬����ͨ���������� next ָ���ٴε���������д��ڻ���
 * Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ��
 * �������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���ע�⣺pos
 * ����Ϊ�������д��ݣ�������Ϊ�˱�ʶ�����ʵ�������
 *
 * ��������д��ڻ����򷵻� true �� ���򣬷��� false ��
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/linked-list-cycle
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author jtchen
 * @date 2020/11/23 13:32
 * @version 1.0
 ************************************************/

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        var theSet = new HashMap<ListNode, Integer>();
        ListNode tmp = head;
        while (tmp != null) {
            if (theSet.containsKey(tmp)) return true;
            theSet.put(tmp, 0);
            tmp = tmp.next;
        }
        return false;
    }
}