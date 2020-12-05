package com.leetcode.algorithm.No746;

/************************************************
 * @description dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i]
 *              dp[i] : ����i+1����������Ҫ��������ֵ
 *                      �п�������һ��������һ����Ҳ�п��������ϸ�����������
 *                      ����ٷ�������ߵ����ĸ����ݣ�������һ/�ڶ�����
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
