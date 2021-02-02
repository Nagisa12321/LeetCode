package com.leetcode.intermediate.No8.No5;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/1 10:51
 */
public class Solution {
    public int mySqrt(int x) {
        int lo = 0, hi = x;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) return (int) mid;
            else if (mid * mid < x) lo = (int) mid + 1;
            else hi = (int) mid - 1;
        }

        return 0;
    }
}
