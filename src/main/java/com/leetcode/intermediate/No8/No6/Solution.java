package com.leetcode.intermediate.No8.No6;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/1 11:17
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        } else if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) return -dividend;// 只要不是最小的那个整数，都是直接返回相反数就好啦
            return Integer.MAX_VALUE;
        }

        boolean isPositive = (dividend >= 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        long a = dividend, b = divisor;
        if (a < 0) a = -a;
        if (b < 0) b = -b;

        int power = 1;
        int sign = 0;
        while (multi(power + power, b) < a) {
            power <<= 1;
            sign = 1;
        }

        int lo = power, hi = power + power;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (multi(mid, b) <= a && multi(mid + 1, b) > a) {
                power = mid;
                sign = 1;
                break;
            } else if (multi(mid, b) > a) hi = mid - 1;
            else lo = mid + 1;
        }
        return isPositive ? power * sign : -power * sign;
    }

    // return x*y
    public long multi(long x, long y) {
        long ans = 0;
        while (y != 0) {
            if (((y & 1) == 1)) ans += x;
            y >>= 1;
            x += x;
        }

        return ans;
    }
}