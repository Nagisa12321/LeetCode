package com.leetcode.interview.No17.No09;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/18 9:46
 */
public class Solution {
	public int getKthMagicNumber(int k) {
		int[] dp = new int[k + 1];
		// dp[i] 表示第i个丑数为...
		// 上一个的下标
		int three = 1, five = 1, seven = 1;
		dp[1] = 1;
		for (int i = 2; i <= k; i++) {
			int min = dp[three] * 3;
			if (dp[three] * 3 < min && dp[three] * 3 > dp[i - 1]) min = dp[three] * 3;
			if (dp[five] * 5 < min && dp[five] * 5 > dp[i - 1]) min = dp[five] * 5;
			if (dp[seven] * 7 < min && dp[seven] * 7 > dp[i - 1]) min = dp[seven] * 7;

			dp[i] = min;

			if (min == dp[three] * 3) three++;
			else if (min == dp[five] * 5) five++;
			else seven++;
		}
		return dp[k];
	}

}
