package com.leetcode.recursion.No4.No2;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/17 13:20
 */

// ¿ìËÙÃİ
public class Solution2 {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }

        return fastPow(x, N);
    }

    public double fastPow(double x, long N) {
        if (N == 0) return 1.0;

        double half = fastPow(x, N / 2);
        if (N % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}