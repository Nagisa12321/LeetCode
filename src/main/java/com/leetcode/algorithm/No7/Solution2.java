package com.leetcode.algorithm.No7;

public class Solution2 {
    public int reverse(int x) {
        int sum = 0;
        while (x != 0) {
            if ((sum * 10) / 10 != sum)
                return 0;
            sum = 10 * sum + x % 10;
            x /= 10;
        }
        return sum;
    }
}
