package com.leetcode.queueorstack.BFS.No2;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/5 18:36
 */
public class Solution2 {
	public int numSquares(int n) {
		if (n == 0) return 0;
		int[] dp = new int[n + 1];
		Arrays.fill(dp, n);
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			int num = 1;
			int pow;
			while ((pow = num * num) <= i) {
				dp[i] = Math.min(dp[i], 1 + dp[i - pow]);
				num++;
			}
		}

		return dp[n];
	}
}
