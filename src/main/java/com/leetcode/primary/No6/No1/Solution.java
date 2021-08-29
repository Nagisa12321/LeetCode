package com.leetcode.primary.No6.No1;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/12/3 11:34
 * @version 1.0
 ************************************************/
public class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n - 1];
    }
}