package com.leetcode.offer.No64;

public class Solution {
    int res = 0;

    public int sumNums(int n) {
        boolean x = n > 1 && n + sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}
