package com.leetcode.intermediate.No8.No4;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/1 10:48
 */
public class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            N = -N;
            x = 1 / x;
        }

        return LongPow(x, N);
    }

    public double LongPow(double x, long n) {
        if (n == 1) return x;
        else if (n == 0) return 1;

        double half = LongPow(x, n / 2);
        if (n % 2 == 1) {
            return half * half * x;
        } else {
            return half * half;
        }
    }
}