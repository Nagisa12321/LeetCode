package com.leetcode.offer.No41;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/14 22:47
 */
public class MedianFinder {

    TreeSet<Integer> set;
    boolean isOdd;


    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        set = new TreeSet<>();
        isOdd = false;
    }

    public void addNum(int num) {
        if (set.add(num))
            isOdd = !isOdd;
    }

    public double findMedian() {
        ArrayList<Integer> list = new ArrayList<>(set);
        int len = set.size();
        if (isOdd) {
            return (double) list.get(len / 2);
        } else {
            return ((double) list.get(len / 2) + (double) list.get(len / 2 + 1)) / 2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */