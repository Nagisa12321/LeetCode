package com.leetcode.algorithm.No518;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/10 23:17
 */
public class Solution {
	public int change(int amount, int[] coins) {
		// dp[i] : 凑成总金额为i的可能性有dp[i]种
		// dp[i] = for(coins) ...
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i >= coin)
					dp[i] += dp[i - coin];
			}
		}
		return dp[amount];
	}
}