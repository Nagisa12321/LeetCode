package com.leetcode.algorithm.No1143;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/3 11:39
 */
public class Solution {
	public int longestCommonSubsequence(String text1, String text2) {
		char[] chs1 = text1.toCharArray();
		char[] chs2 = text2.toCharArray();

		int[][] dp = new int[chs1.length + 1][26];
		for (int i = 0; i < chs1.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (dp[j][chs1[i] - 'a'] == 0) dp[j][chs1[i] - 'a'] = i + 1;
			}
		}

		int maxLen = 0;
		for (int j = 0; j < chs2.length; j++){
			int len = 0;
			int state = 0;
			for (int i = j; i < chs2.length; i++) {
				// != 0说明可以转换状态, 证明len++
				if (dp[state][chs2[i] - 'a'] != 0) {
					state = dp[state][chs2[i] - 'a'];
					len++;
				}
			}
			maxLen = Math.max(maxLen, len);
		}

		return maxLen;
	}
}