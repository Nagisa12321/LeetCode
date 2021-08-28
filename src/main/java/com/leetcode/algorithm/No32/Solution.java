package com.leetcode.algorithm.No32;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/1 12:00
 */
public class Solution {
	public int longestValidParentheses(String s) {
		char[] chs = s.toCharArray();
		int len = chs.length;
		boolean[][] dp = new boolean[len][len];

		// dp[i][j]: s[i] 到 s[j]是否为有效的括号
		int max = 0;
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				// s[i]到s[j]是奇数位, 那么肯定不是有效的括号
				if (((j - i + 1) & 1) == 1) {
					dp[i][j] = false;
				}
				// 如果s[i]是), 那么肯定不是有效的括号
				else if (chs[i] == ')') {
					dp[i][j] = false;
				}
				// i, j相邻
				else if (j == i + 1) {
					dp[i][j] = chs[j] == ')';
				}
				// 情况1: s[i] == (, s[j] == ), dp[i + 1][j - 1] = true
				else if ((chs[j] == ')' && dp[i + 1][j - 1])) {
					dp[i][j] = true;
				}
				// 最后一种情况: 逐位匹配
				else if (chs[j] == ')') {
					for (int k = i; k < j; k++) {
						if (dp[i][k] && dp[k + i][j]) {
							dp[i][j] = true;
							break;
						}
					}
				}
				if (dp[i][j]) {
					if (j - i + 1 > max) {
						max = j - i + 1;
					}
				}
			}
		}

		return max;
	}
}