package com.leetcode.algorithm.No62;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/9 19:51
 * @version 1.0
 ************************************************/
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (i == 0 || j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        return dp[m - 1][n - 1];
    }
}
