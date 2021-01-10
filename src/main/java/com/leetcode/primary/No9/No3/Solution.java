package com.leetcode.primary.No9.No3;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/14 12:59
 * @version 1.0
 ************************************************/
public class Solution {
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret = (ret << 1) + (n & 1);
            n >>= 1;
        }
        return ret;
    }
}
