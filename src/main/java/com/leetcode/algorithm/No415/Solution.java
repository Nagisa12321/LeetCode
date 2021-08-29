package com.leetcode.algorithm.No415;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/17 15:13
 */
public class Solution {
	public String addStrings(String num1, String num2) {
		char[] chs_1 = num1.toCharArray();
		char[] chs_2 = num2.toCharArray();

		StringBuilder builder = new StringBuilder();
		int idx_1 = chs_1.length - 1;
		int idx_2 = chs_2.length - 1;
		int cf = 0; // 进位标志

		while (idx_1 >= 0 && idx_2 >= 0) {
			int tmp = chs_1[idx_1] - '0' + chs_2[idx_2] - '0' + cf;
			cf = tmp / 10;
			tmp %= 10;
			builder.append((char) (tmp + '0'));
			idx_1--;
			idx_2--;
		}

		while (idx_1 >= 0) {
			int tmp = chs_1[idx_1] - '0' + cf;
			cf = tmp / 10;
			tmp %= 10;
			builder.append((char) (tmp + '0'));
			idx_1--;
		}

		while (idx_2 >= 0) {
			int tmp = chs_2[idx_2] - '0' + cf;
			cf = tmp / 10;
			tmp %= 10;
			builder.append((char) (tmp + '0'));
			idx_2--;
		}

		if (cf == 1)
			builder.append('1');

		return builder.reverse().toString();
	}
}