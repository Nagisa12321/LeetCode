package com.leetcode.primary.No1.No2;

/**
 * 贪心算法：只计算增加量
 */
public class Solution2 {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i = 1;i != prices.length;++i){
            if(prices[i] - prices[i - 1] > 0)sum += prices[i] - prices[i - 1];
        }
        return sum;
    }
}
