package com.leetcode.algorithm.No191;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/12/8 12:32
 * @version 1.0
 ************************************************/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) sum++;
            n >>= 1;
        }
        return sum;
    }
}
