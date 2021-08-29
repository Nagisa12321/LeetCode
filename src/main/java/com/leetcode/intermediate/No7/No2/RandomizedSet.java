package com.leetcode.intermediate.No7.No2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/30 13:48
 */
public class RandomizedSet {
    private HashSet<Integer> set;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        set = new HashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        return set.add(val);
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        return set.remove(val);
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        var list = new ArrayList<>(set);
        return list.get(new Random().nextInt(set.size()));
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
