package com.leetcode.offer.No14.No2;

import java.math.BigInteger;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/29 11:31
 */
public class Solution {
	public int cuttingRope(int n) {
		BigInteger[] dp;
		if (n <= 6) dp = new BigInteger[7];
		else dp = new BigInteger[n + 1];
		dp[2] = BigInteger.valueOf(1);
		dp[3] = BigInteger.valueOf(2);
		dp[4] = BigInteger.valueOf(4);
		dp[5] = BigInteger.valueOf(6);
		dp[6] = BigInteger.valueOf(9);

		for (int i = 7; i <= n; i++) {
			dp[i] = dp[i].max(dp[i - 2].multiply(BigInteger.valueOf(2))).max(dp[i - 3].multiply(BigInteger.valueOf(3)));
		}

		return (int) dp[n].longValue() % 1000000007;
	}
}