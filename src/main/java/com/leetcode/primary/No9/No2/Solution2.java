package com.leetcode.primary.No9.No2;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/14 12:36
 * @version 1.0
 ************************************************/
public class Solution2 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        xor = (xor & 0x55555555) + ((xor >> 1) & 0x55555555);//合并2位数
        xor = (xor & 0x33333333) + ((xor >> 2) & 0x33333333);//合并4位数
        xor = (xor & 0x0f0f0f0f) + ((xor >> 4) & 0x0f0f0f0f);//合并8位数
        xor = (xor & 0x00ff00ff) + ((xor >> 8) & 0x00ff00ff);//合并16位数
        xor = (xor & 0x0000ffff) + ((xor >> 16) & 0x0000ffff);//合并32位数
        return xor;
    }
}
