package com.leetcode.algorithm.No1035;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/21 9:50
 */
public class Solution {
	public int maxUncrossedLines(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		// dp[i][j]: nums1[0:i], nums2[0:j]不相交的线条有多少
		int[][] dp = new int[len1][len2];
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				if (nums1[i] == nums2[j]) {
					dp[i][j] = i == 0 || j == 0 ? 1 : dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(i == 0 ? 0 : dp[i - 1][j], j == 0 ? 0 :dp[i][j - 1]);
				}
			}
		}
		return dp[len1 - 1][len2 - 1];
	}
}