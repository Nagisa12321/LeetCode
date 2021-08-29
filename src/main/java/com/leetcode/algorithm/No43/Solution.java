package com.leetcode.algorithm.No43;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/27 15:25
 */
public class Solution {
	public String multiply(String num1, String num2) {
		char[] chs_2 = num2.toCharArray();
		String result = "0";
		// 下面的数
		for (char c : chs_2) {
			String tmp = multi(num1, c);
			result = multi10(result);
			result = add(tmp, result);
		}
		return result;
	}

	// 返回 num1 * num2
	private String multi(String num1, char num2) {
		StringBuilder builder = new StringBuilder();
		int cf = 0;
		char[] chs_1 = num1.toCharArray();
		int idx_1 = chs_1.length - 1;

		while (idx_1 >= 0 || cf > 0) {
			int now = cf +
					(idx_1 >= 0 ? chs_1[idx_1] - '0' : 0) *
							(num2 - '0');
			cf = now / 10;
			now %= 10;

			builder.append(now);
			idx_1--;
		}

		String result = builder.reverse().toString();
		if (result.charAt(0) == '0') return "0";
		return result;
	}

	// 返回 num1 * 10
	private String multi10(String num1) {
		if (num1.equals("0")) return "0";
		return num1 + "0";
	}

	// 返回 num1 + num2
	private String add(String num1, String num2) {
		StringBuilder builder = new StringBuilder();
		int cf = 0;
		char[] chs_1 = num1.toCharArray();
		char[] chs_2 = num2.toCharArray();
		int idx_1 = chs_1.length - 1;
		int idx_2 = chs_2.length - 1;

		while (idx_1 >= 0 || idx_2 >= 0 || cf > 0) {
			int now = cf +
					(idx_1 >= 0 ? chs_1[idx_1] - '0' : 0) +
					(idx_2 >= 0 ? chs_2[idx_2] - '0' : 0) ;
			cf = now / 10;
			now %= 10;

			builder.append(now);
			idx_1--;
			idx_2--;
		}

		return builder.reverse().toString();
	}
}