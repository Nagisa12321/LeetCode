package com.leetcode.linkedList.No5.No5;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2020/12/29 16:01
 */

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public Node copyRandomList(Node head) {
        // map<���ڵ�, randomָ��ڵ�>
        var map = new HashMap<Node, Node>();

        // ����Դ����������, ˳��д������ɷ��漴����
        Node tmp = head;
        Node res = null;
        Node res1 = null;
        while (tmp != null) {
            // �������
            map.put(tmp, tmp.random);

            // д���������
            if (res == null) {
                res = new Node(tmp.val);
                res1 = res;
            } else {
                var node = new Node(tmp.val);
                res1.next = node;
                res1 = res1.next;
            }

            // ���½ڵ�
            tmp = tmp.next;
        }

        // �ٱ���һ��������, ������ڵ�
        tmp = head;
        res1 = res;
        while (tmp != null) {
            // ��HashMap��ȡ�ýڵ�, �����Ǵ�ͷ�ڵ�ĵڼ����õ���
            Node random = map.get(tmp);
            int idx = 0;
            Node tmp2 = head;
            while (tmp2 != random) {
                tmp2 = tmp2.next;
                idx++;
            }

            //��Ѱtmp������ڵ�tmp2
            if (tmp2 != null) {
                tmp2 = res;
                for (int i = 0; i < idx; i++) tmp2 = tmp2.next;
            }

            // ��ֵ!
            res1.random = tmp2;

            // ���½ڵ�
            tmp = tmp.next;
            res1 = res1.next;
        }
        return res;
    }
}