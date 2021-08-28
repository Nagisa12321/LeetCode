package com.leetcode.interview.real;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//s
//		String line = scanner.nextLine();
//		System.out.println(subZero(line));

		System.out.println(subZero("0111100101"));
	}

	private static int subZero(String line) {
		char[] chs = line.toCharArray();
		int len = chs.length;

		// dp[i] - 以i为结束, num(0)-num(1)的最大值
		int[] dp = new int[len];

		int res = 0;
		for (int i = 0; i < len; i++) {
			if (i == 0)
				dp[i] = chs[0] == '0' ? 1 : 0;
			else {
				if (chs[i] == '0') {
					dp[i] = Math.max(1, dp[i - 1] + 1);
				} else {
					dp[i] = Math.max(-1, dp[i - 1] - 1);
				}
			}

			res = Math.max(res, dp[i]);
		}

		return res;
	}
}
