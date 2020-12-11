package com.leetcode.algorithm.No714;

/************************************************
 *
 * @author jtchen
 * @since 2020/12/8 17:05
 * @version 1.0
 ************************************************/
public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                if (prices[i] - fee > prices[i - 1])
                    prices[i] -= fee;
                else prices[i] = prices[i - 1];
            }
        }
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                dp += prices[i] - prices[i - 1];
        }
        return dp;
    }
}
