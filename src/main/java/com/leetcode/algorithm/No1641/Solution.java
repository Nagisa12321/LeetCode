package com.leetcode.algorithm.No1641;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/12/8 11:30
 * @version 1.0
 ************************************************/
public class Solution {
    public int countVowelStrings(int n) {
        if (n == 0) return 5;
        int[][] dp = new int[n + 1][5];
        for (int i = 0; i < 5; i++) dp[0][i] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2];
            dp[i][3] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3];
            dp[i][4] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4];
        }
        return dp[n - 1][0] + dp[n - 1][1] + dp[n - 1][2] + dp[n - 1][3] + dp[n - 1][4];
    }
}
