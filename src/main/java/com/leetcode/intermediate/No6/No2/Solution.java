package com.leetcode.intermediate.No6.No2;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/30 10:30
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 1;
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}