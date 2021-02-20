package com.leetcode.offer.No66;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/19 12:02
 */

// ³¬Ê±
public class Solution {
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = 1;

            for (int j = 0; j < a.length; j++) {
                res[i] *= j == i ? 1 : a[j];
            }
        }
        return res;
    }
}