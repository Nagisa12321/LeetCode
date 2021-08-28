package com.leetcode.algorithm.No97;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/28 21:52
 */
public class Solution2 {
	public boolean isInterleave(String str1, String str2, String str3) {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		char[] s3 = str3.toCharArray();
		int len1 = s1.length;
		int len2 = s2.length;
		boolean[][] dp = new boolean[len1][len2];
		dp[0][0] = true;
		int i = 0;
		for (i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if (i == 0 && j == 0) continue;
				else if (i == 0) {
					if (s2[j - 1] == s3[i + j - 1]) {
						dp[i][j] = dp[i][j - 1];
					} else dp[i][j] = false;
				} else if (j == 0) {
					if (s1[i - 1] == s3[i + j - 1]) {
						dp[i][j] = dp[i - 1][j];
					} else dp[i][j] = false;
				} else {
					if (s1[i - 1] == s3[i + j - 1] && s2[j - 1] == s3[i + j - 1]) {
						dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
					} else if (s1[i - 1] == s3[i + j - 1]) {
						dp[i][j] = dp[i - 1][j];
					} else if (s2[j - 1] == s3[i + j - 1]) {
						dp[i][j] = dp[i][j - 1];
					} else dp[i][j] = false;
				}
			}
		}
		return dp[len1 - 1][len2 - 1];
	}
}
