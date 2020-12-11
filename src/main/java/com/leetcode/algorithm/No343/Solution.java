package com.leetcode.algorithm.No343;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/9 15:53
 * @version 1.0
 ************************************************/
public class Solution {
    public int integerBreak(int n) {
        int[] dp;
        if (n <= 6) dp = new int[7];
        else dp = new int[n + 1];
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        dp[5] = 6;
        dp[6] = 9;
        for (int i = 7; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3);
        }
        return dp[n];
    }
}
