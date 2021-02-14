package com.leetcode.hashmap.No1.No1;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/4 9:40
 */
public class MyHashSet2 {

    private final Node[] nodes;
    private static final int BUCKET_NUM = 769;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet2() {
        nodes = new Node[BUCKET_NUM];
    }

    public void add(int key) {
        int bucket = fun(key);
        if (nodes[bucket] == null) {
            nodes[bucket] = new Node(key);
        } else {
            Node tmp = nodes[bucket];
            if (tmp.val == key) return;
            while (tmp.next != null) {
                if (tmp.next.val == key) return;
                tmp = tmp.next;
            }
            tmp.next = new Node(key);
        }
    }

    public void remove(int key) {
        int bucket = fun(key);
        if (nodes[bucket] != null) {
            Node tmp = nodes[bucket];
            if (tmp.val == key) {
                nodes[bucket] = tmp.next;
            } else {
                while (tmp.next != null && tmp.next.val != key)
                    tmp = tmp.next;
                if (tmp.next != null) tmp.next = tmp.next.next;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int bucket = fun(key);
        if (nodes[bucket] != null) {
            Node tmp = nodes[bucket];
            if (tmp.val == key) return true;
            while (tmp != null) {
                if (tmp.val == key) return true;
                tmp = tmp.next;
            }
        }
        return false;
    }


    private int fun(int key) {
        return key % BUCKET_NUM;
    }

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public String toString() {
        boolean hasItem = false;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < BUCKET_NUM; i++) {
            if (nodes[i] != null) {
                hasItem = true;
                builder.append(i).append(" -> ");
                Node tmp = nodes[i];
                while (tmp != null) {
                    if (tmp.next == null) {
                        builder.append(tmp.val).append(";\n");
                    } else {
                        builder.append(tmp.val).append(", ");
                    }
                    tmp = tmp.next;
                }
            }
        }
        if (!hasItem) return "empty";
        return builder.toString();
    }
}