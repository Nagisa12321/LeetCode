package com.leetcode.recursion.No4.No2;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/17 13:07
 */

// out of time
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        double res = x;
        for (int i = 0; i < n - 1; i++)
            res *= x;
        return res;
    }
}