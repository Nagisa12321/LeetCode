package com.leetcode.algorithm.No322;

import java.util.Arrays;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/12/3 15:39
 * @version 1.0
 ************************************************/
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i)
            for (int coin : coins) {
                if (i - coin <= 0) continue;
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}