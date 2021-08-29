package com.leetcode.offer.No66;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/19 12:05
 */
public class Solution2 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] res = new int[len];
        int[] before = new int[len];
        int cur = 1;

        for (int i = len - 1; i >= 0; i--) {
            if (i != len - 1) {
                before[i] = cur;
                cur *= a[i];
            } else {
                before[i] = 1;
                cur = a[len - 1];
            }
        }

        cur = 1;
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                res[i] = cur * before[i];
                cur *= a[i];
            } else {
                cur = a[0];
                res[i] = before[i];
            }
        }
        return res;
    }
}
