package com.leetcode.offer.No10.frog;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/10 9:22
 */
public class Solution {
    public int numWays(int n) {
        if (n == 0 || n == 1) return 1;

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }

        return dp[n];
    }
}