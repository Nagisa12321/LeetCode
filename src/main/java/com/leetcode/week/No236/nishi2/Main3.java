package com.leetcode.week.No236.nishi2;

import java.util.Scanner;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/15 11:40
 */
public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		System.out.println(add(s));
	}

	public static int add(String s) {
		int len = s.length();
		if (len == 1) return 0;
		int max = 1;
		// dp[i][j]: s[i]-s[j]�Ƿ�Ϊ�����Ӵ�
		boolean[][] dp = new boolean[len][len];

		// dp[i][i]�϶��ǻ����ִ�
		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
		}

		// ���dp[i][j], ������max�ҳ�result
		for (int i = len - 1; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {
				if (s.charAt(i) == s.charAt(j) && (j == i + 1 || dp[i + 1][j - 1])) {
					dp[i][j] = true;
					if (j - i + 1 > max) {
						max = j - i + 1;
					}
				}
			}
		}
		for (int i = 0; i < len; i++) {
			if (dp[i][len - 1])
				return i;
		}
		return len;
	}
}
