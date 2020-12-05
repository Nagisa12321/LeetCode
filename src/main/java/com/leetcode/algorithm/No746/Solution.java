package com.leetcode.algorithm.No746;

/************************************************
 * @description dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i]
 *              dp[i] : 爬到i+1阶梯最少需要多少体力值
 *                      有可能是上一个阶梯走一步，也有可能是上上个阶梯走两步
 *                      最后再返回最后走的是哪个阶梯（倒数第一/第二？）
 * @author jtchen
 * @date 2020/12/5 21:43
 * @version 1.0
 ************************************************/
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 0) return 0;
        else if (cost.length == 1) return cost[0];
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++)
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
