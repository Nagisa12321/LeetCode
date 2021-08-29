package com.leetcode.offer.No44;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/19 10:42
 */
public class Solution {
    public int findNthDigit(int n) {
        long num = 9;
        int bit = 1;
        long start = 0;
        while (n > num * bit) {
            if (num == 9) n -= 10;
            else n -= num * bit;

            num *= 10;
            if (start == 0) start = 10;
            else start *= 10;
            bit++;
        }
        n++;
        // long idx = (n - 1) / bit; // 第几位(从0算)
        // long start = num / 10 + (int) Math.pow(10, bit - 2);
        // 数字中的第几位(从0算, 从左数)

        // 求出相应数字
        // while (idx > 0) {
        //     start++;
        //     idx--;
        // }
        start = start + (n - 1) / bit;

        // for (int i = 0; i < bit - cur - 1; i++) {
        //     start /= 10;
        // }

        // return (int) start % 10;
        return Long.toString(start).charAt((n - 1) % bit) - '0';
    }
}