package com.leetcode.algorithm.No1449;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/12 9:46
 */
public class Solution {
	public String largestNumber(int[] cost, int target) {
		BigInteger[] dp = new BigInteger[target + 1];
		for (int i = 0; i <= target; i++) {
			dp[i] = BigInteger.valueOf(0);
		}
		for (int i = 1; i <= target; i++) {
			for (int j = 1; j <= 9; j++) {
				BigInteger jb = BigInteger.valueOf(j);
				if (cost[j - 1] == i) {
					dp[i] = dp[i].max(jb);
				} else if (i - cost[j - 1] > 0) {
					if (!dp[i - cost[j - 1]].equals(BigInteger.valueOf(0))){
						BigInteger ten = BigInteger.valueOf(10);
						BigInteger tmp = dp[i - cost[j - 1]].multiply(ten).add(jb).
								max(jb.multiply(ten).add(dp[i - cost[j - 1]]));
						dp[i] = dp[i].max(tmp);
					}
				}
			}
		}
		return dp[target].toString();
	}

}