package com.leetcode.algorithm.No121;

/**
 *
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int minPrice = prices[0], max = 0;
        for (int i = 1; i != prices.length; ++i) {
            if (prices[i] < minPrice) minPrice = prices[i];
            else max = Math.max(max, prices[i] - minPrice);
        }
        return max;
    }
}
