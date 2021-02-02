package com.leetcode.intermediate.No7.No2;

import java.util.HashMap;
import java.util.Random;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/30 13:52
 */

// 不明原因报错
public class RandomizedSet1 {
    private int[] set;
    private final HashMap<Integer, Integer> map;
    private int idx;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet1() {
        set = new int[16];
        map = new HashMap<>();
        idx = 0;
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        else {
            // 数组满了则扩容
            if (isFull()) raise();

            set[idx] = val;
            map.put(val, idx++);
        }
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int tmpIDX = map.get(val);
            set[tmpIDX] = set[--idx];
            if (map.size() == 1)
                map.clear();
            else {
                map.remove(val);
                map.put(set[idx], tmpIDX);
            }
            return true;
        } else return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {

        return set[(int) (Math.random() * idx)];
    }

    private boolean isFull() {
        return idx == set.length - 1;
    }

    private void raise() {
        int[] tmp = new int[set.length * 2];
        System.arraycopy(set, 0, tmp, 0, set.length);
        set = tmp;
    }

    public String toString() {
        if (idx == 0) return "[]";
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (int i = 0; i < idx; i++) {
            if (i == idx - 1) {
                builder.append(set[i]).append("]");
            } else {
                builder.append(set[i]).append(", ");
            }
        }

        return builder.toString();
    }
}

