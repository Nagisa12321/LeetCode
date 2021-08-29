package com.leetcode.offer.No63;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/11 9:39
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        // dp[i][0] 第i天持股
        // dp[i][i] 第i天不持股
        // dp[i][0] = max(-prices[i], dp[i - 1][0])
        // dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + prices[i])
        dp[0][0] = -prices[0];
        dp[0][1] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}