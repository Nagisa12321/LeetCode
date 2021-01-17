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
        // map<本节点, random指向节点>
        var map = new HashMap<Node, Node>();

        // 遍历源链表计入表中, 顺便写新链表飞非随即部分
        Node tmp = head;
        Node res = null;
        Node res1 = null;
        while (tmp != null) {
            // 存入表中
            map.put(tmp, tmp.random);

            // 写非随机部分
            if (res == null) {
                res = new Node(tmp.val);
                res1 = res;
            } else {
                var node = new Node(tmp.val);
                res1.next = node;
                res1 = res1.next;
            }

            // 更新节点
            tmp = tmp.next;
        }

        // 再遍历一次新链表, 存随机节点
        tmp = head;
        res1 = res;
        while (tmp != null) {
            // 从HashMap中取得节点, 计算是从头节点的第几个得到的
            Node random = map.get(tmp);
            int idx = 0;
            Node tmp2 = head;
            while (tmp2 != random) {
                tmp2 = tmp2.next;
                idx++;
            }

            //找寻tmp的随机节点tmp2
            if (tmp2 != null) {
                tmp2 = res;
                for (int i = 0; i < idx; i++) tmp2 = tmp2.next;
            }

            // 赋值!
            res1.random = tmp2;

            // 更新节点
            tmp = tmp.next;
            res1 = res1.next;
        }
        return res;
    }
}