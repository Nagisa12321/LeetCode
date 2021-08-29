package com.leetcode.algorithm.No1071;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/5 18:56
 */
public class Solution {
	public String gcdOfStrings(String str1, String str2) {
		char[] chs_1 = str1.toCharArray();
		char[] chs_2 = str2.toCharArray();
		int ch1_len = chs_1.length;
		int ch2_len = chs_2.length;

		// 如果两个串不是相互包含关系直接return ""
		for (int i = 0; i < ch1_len && i < ch2_len; i++)
			if (chs_1[i] != chs_2[i]) return "";

		int idx = Math.min(ch1_len, ch2_len) - 1;
		while (idx >= 0) {
			if (divisible(chs_1, idx) && divisible(chs_2, idx))
				return str1.substring(0, idx + 1);
			idx--;
		}
		return "";
	}

	public boolean divisible(char[] chs, int idx) {
		int len = chs.length;
		if (len % (idx + 1) != 0) return false;
		if (idx == len - 1) return true;

		for (int i = 0; i < len; i++) {
			if (chs[i % (idx + 1)] != chs[i]) return false;
		}

		return true;
	}
}