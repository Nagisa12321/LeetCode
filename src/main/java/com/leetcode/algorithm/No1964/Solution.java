package com.leetcode.algorithm.No1964;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/20 10:34
 */
public class Solution {
	public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
		int n = obstacles.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (dp[i] >= j)
					break;
				if (obstacles[j] <= obstacles[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		return dp;
	}
}