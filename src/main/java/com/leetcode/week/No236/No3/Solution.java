package com.leetcode.week.No236.No3;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/11 11:10
 */
public class Solution {
	public int minSideJumps(int[] obstacles) {
		int len = obstacles.length;
		int[][] dp = new int[len][3];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[0][2] = 1;
		for (int i = 1; i < len; i++) {
			dp[i][0] = Integer.MAX_VALUE / 2;
			dp[i][1] = Integer.MAX_VALUE / 2;
			dp[i][2] = Integer.MAX_VALUE / 2;
			if (obstacles[i] != 0)
				dp[i][obstacles[i] - 1] = len; // 标记石头
		}

		for (int i = 1; i < len; i++) {
			for (int j = 0; j < 3; j++) {
				if (dp[i - 1][j] != len && dp[i][j] != len) {
					if (j == 0) {
						if (dp[i][1] == len) dp[i][0] = Math.min(dp[i - 1][0], dp[i][2] + 1);
						else dp[i][0] = Math.min(dp[i - 1][0], dp[i][1] + 1);
					} else if (j == 1) {
						dp[i][1] = Math.min(Math.min(dp[i - 1][1], dp[i][0] + 1), dp[i][2] + 1);
					} else {
						if (dp[i][1] == len) dp[i][2] = Math.min(dp[i - 1][2], dp[i][0] + 1);
						else dp[i][2] = Math.min(dp[i - 1][2], dp[i][1] + 1);
					}
				}
			}
			for (int j = 0; j < 3; j++) {
				if (dp[i - 1][j] == len && dp[i][j] != len) {
					if (j == 0) {
						if (dp[i][1] == len) dp[i][0] = Math.min(dp[i - 1][0], dp[i][2] + 1);
						else dp[i][0] = Math.min(dp[i - 1][0], dp[i][1] + 1);
					} else if (j == 1) {
						dp[i][1] = Math.min(Math.min(dp[i - 1][1], dp[i][0] + 1), dp[i][2] + 1);
					} else {
						if (dp[i][1] == len) dp[i][2] = Math.min(dp[i - 1][2], dp[i][0] + 1);
						else dp[i][2] = Math.min(dp[i - 1][2], dp[i][1] + 1);
					}
				}
			}
		}

		return Math.min(Math.min(dp[len - 1][0], dp[len - 1][1]), dp[len - 1][2]);
	}
}