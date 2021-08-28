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

		// dp[i][j]: s[i] �� s[j]�Ƿ�Ϊ��Ч������
		int max = 0;
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				// s[i]��s[j]������λ, ��ô�϶�������Ч������
				if (((j - i + 1) & 1) == 1) {
					dp[i][j] = false;
				}
				// ���s[i]��), ��ô�϶�������Ч������
				else if (chs[i] == ')') {
					dp[i][j] = false;
				}
				// i, j����
				else if (j == i + 1) {
					dp[i][j] = chs[j] == ')';
				}
				// ���1: s[i] == (, s[j] == ), dp[i + 1][j - 1] = true
				else if ((chs[j] == ')' && dp[i + 1][j - 1])) {
					dp[i][j] = true;
				}
				// ���һ�����: ��λƥ��
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