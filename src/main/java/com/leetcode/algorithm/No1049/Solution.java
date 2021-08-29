package com.leetcode.algorithm.No1049;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/8 10:10
 */
public class Solution {
	public int lastStoneWeightII(int[] stones) {
		int len = stones.length;
		int sum = 0;
		for (int stone : stones) { sum += stone; }
		// dp[i][j]: 当最大容量为j的时候, 前i块石头最大能放多少
		int[][] dp = new int[len][sum / 2 + 1];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j <= sum / 2; j++) {
				if (j >= stones[i]) {
					dp[i][j] =
							Math.max((i == 0 ? 0 : dp[i - 1][j]),
									(i == 0 ? 0 : dp[i - 1][j - stones[i]]) + stones[i]);
				} else {
					if (i == 0) {
						dp[i][j] = 0;
					} else dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return sum - dp[len - 1][sum / 2] * 2;
	}
}