package com.leetcode.primary.No9.No2;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/14 12:24
 * @version 1.0
 ************************************************/
public class Solution {
    public int hammingDistance(int x, int y) {
        int[] a = new int[32];
        int[] b = new int[32];
        int index = 0;
        while (x != 0) {
            a[index++] = x % 2;
            x /= 2;
        }
        index = 0;
        while (y != 0) {
            b[index++] = y % 2;
            y /= 2;
        }
        int len = 0;
        for (int i = 0; i < 32; i++) {
            if (a[i] != b[i]) len++;
        }
        return len;
    }
}
