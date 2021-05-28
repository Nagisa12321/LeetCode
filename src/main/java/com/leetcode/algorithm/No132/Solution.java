package com.leetcode.algorithm.No132;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/9 13:56
 */
public class Solution {

	private int min;
	private int[] count;

	public int minCut(String s) {
		char[] chs = s.toCharArray();
		int len = chs.length;
		min = len;
		count = new int[len];

		for (int i = 0; i < len; i++)
			count[i] = i + 1;
		boolean[][] dp = new boolean[len][len];

		for (int i = len - 1; i >= 0; i--) {
			for (int j = i; j < len; j++) {
				if (j == i)
					dp[i][j] = true;
				else if (j == i + 1)
					dp[i][j] = chs[i] == chs[j];
				else
					dp[i][j] = dp[i + 1][j - 1] && chs[i] == chs[j];
			}
		}

		track(dp, chs, 0, 0);

		return min - 1;
	}

	public void track(boolean[][] dp, char[] chs, int i, int cut) {
		int len = chs.length;
		if (i == len) {
			min = Math.min(cut, min);
			return;
		}

		if (count[i] < cut) return;
		else count[i] = cut;

		for (int j = len - 1; j >= i; j--) {
			if (dp[i][j]) {
				track(dp, chs, j + 1, cut + 1);
			}
		}
	}
}