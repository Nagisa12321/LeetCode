package com.leetcode.recursion.No4.No2;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/17 13:34
 */
public class Solution3 {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        long N = n;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }

        double ans = 1;
        double current = x;

        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1)
                ans = ans * current;
            current *= current;
        }

        return ans;
    }
}