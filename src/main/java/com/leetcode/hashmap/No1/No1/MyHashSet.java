package com.leetcode.hashmap.No1.No1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/4 9:14
 */
public class MyHashSet {
    private List<List<Integer>> lists;
    /** Initialize your data structure here. */
    public MyHashSet() {
        lists = new ArrayList<>(769);
        for (int i = 0; i < 769; i++)
            lists.add(new LinkedList<>());
    }

    public void add(int key) {
        if (contains(key)) return;
        int bucket = fun(key);
        lists.get(bucket).add(key);
    }

    public void remove(int key) {
        int bucket = fun(key);
        lists.get(bucket).remove((Object)key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = fun(key);
        return lists.get(bucket).contains(key);
    }

    private int fun(int key) {
        return key % 769;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */