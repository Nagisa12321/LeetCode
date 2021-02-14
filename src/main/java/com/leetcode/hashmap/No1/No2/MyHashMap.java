package com.leetcode.hashmap.No1.No2;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/4 10:28
 */
public class MyHashMap {
    private static final int BUCKET_NUM = 769;
    private final PairNode[] nodes;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        nodes = new PairNode[BUCKET_NUM];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int bucket = fun(key);
        if (nodes[bucket] == null) {
            nodes[bucket] = new PairNode(key, value);
        } else {
            PairNode tmp = nodes[bucket];
            if (tmp.key == key) {
                tmp.val = value;
                return;
            }
            while (tmp.next != null) {
                if (tmp.next.key == key) {
                    tmp.val = value;
                    return;
                }
                tmp = tmp.next;
            }
            tmp.next = new PairNode(key, value);
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int bucket = fun(key);
        if (nodes[bucket] != null) {
            PairNode tmp = nodes[bucket];
            if (tmp.key == key) return tmp.val;
            while (tmp != null) {
                if (tmp.key == key) return tmp.val;
                tmp = tmp.next;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int bucket = fun(key);
        if (nodes[bucket] != null) {
            PairNode tmp = nodes[bucket];
            if (tmp.key == key) {
                nodes[bucket] = tmp.next;
            } else {
                while (tmp.next != null && tmp.next.key != key)
                    tmp = tmp.next;
                if (tmp.next != null) tmp.next = tmp.next.next;
            }
        }
    }

    private int fun(int key) {
        return key % BUCKET_NUM;
    }

    public String toString() {
        boolean hasNode = false;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < BUCKET_NUM; i++) {
            if (nodes[i] != null) {
                hasNode = true;
                PairNode tmp = nodes[i];
                while (tmp != null) {
                    builder.append(tmp.key)
                            .append(" -> ")
                            .append(tmp.val)
                            .append('\n');
                    tmp = tmp.next;
                }
            }
        }
        if (hasNode) return builder.toString();
        else return "empty";
    }

    private static class PairNode {
        int key;
        int val;
        PairNode next;

        public PairNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}