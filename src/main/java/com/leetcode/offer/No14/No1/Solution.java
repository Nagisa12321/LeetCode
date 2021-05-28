package com.leetcode.offer.No14.No1;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/18 17:43
 */
public class Solution {
    public int cuttingRope(int n) {
        int[] dp;
        if (n < 7) dp = new int[8];
        else dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;

        for (int i = 7; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, dp[i - j] * j);
            }
            dp[i] = max;
        }

        return dp[n];
    }
}