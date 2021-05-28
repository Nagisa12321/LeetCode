package com.leetcode.algorithm.No151;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 16:00
 */
public class Solution {
	public String reverseWords(String s) {
		int state = 0;
		int left = 0;
		char ch = ' ';
		int wordIdx = 0;

		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);

			if (ch == ' ') {
				if (state == 0) {
					s = s.substring(0, i) + s.substring(i + 1);
					i--;
				} else {
					s = reserve(s, left, i);
					left = i + 1;
					state = 0;
				}
			} else {
				if (state == 0) {
					state = 1;
				}
				wordIdx = i;
			}
		}

		if (ch == ' ')
			s = s.substring(0, wordIdx + 1);
		else s = reserve(s, left, s.length());

		return reserve(s);
	}

	// [left, right)
	public String reserve(String s, int left, int right) {
		String str_left = s.substring(0, left);
		String str_reserve = s.substring(left, right);
		String str_right = s.substring(right);

		str_reserve = reserve(str_reserve);

		return str_left + str_reserve + str_right;
	}

	public String reserve(String s) {
		if (s.equals("")) return "";

		char ch = s.charAt(0);
		String substring = s.substring(1);

		return reserve(substring) + ch;
	}
}