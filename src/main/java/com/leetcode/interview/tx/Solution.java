package com.leetcode.interview.tx;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/26 15:38
 */
public class Solution {

	public String findMaxLen(String s) {
		if (s.equals(""))
			return s;
		char[] chs = s.toCharArray();
		int len = chs.length;

		// dp[i] - 到下标为i的时候, 最长字符串的长度为多少
		int[] dp = new int[len];
		int begin = 0, end = 0;
		int max = 1;
		dp[0] = 1;
		for (int i = 1; i < len; i++) {
			if (chs[i] == chs[i - 1])
				dp[i] = dp[i - 1] + 1;
			else dp[i] = 1;

			if (dp[i] > max) {
				max = dp[i];
				end = i;
				begin = i - dp[i] + 1;
			}
		}
		char ch = chs[end];
		return String.valueOf(ch).repeat(Math.max(0, end - begin + 1));
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findMaxLen(""));
	}
}
