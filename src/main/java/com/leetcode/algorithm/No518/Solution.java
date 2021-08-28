package com.leetcode.algorithm.No518;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/10 23:17
 */
public class Solution {
	public int change(int amount, int[] coins) {
		// dp[i] : �ճ��ܽ��Ϊi�Ŀ�������dp[i]��
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