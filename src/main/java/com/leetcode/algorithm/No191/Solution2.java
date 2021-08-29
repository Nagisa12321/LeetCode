package com.leetcode.algorithm.No191;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/12/8 13:01
 * @version 1.0
 ************************************************/
public class Solution2 {
    public int hammingWeight(int n) {
        n = (n & 0x55555555) + ((n >> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
        n = (n & 0x07070707) + ((n >> 4) & 0x07070707);
        n = (n & 0x00770077) + ((n >> 8) & 0x00770077);
        return n;
    }
}
