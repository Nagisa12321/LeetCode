package com.leetcode.algorithm.No557;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 21:30
 */
public class Solution {
	public String reverseWords(String s) {
		char[] chs = s.toCharArray();

		int left = 0;
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == ' ') {
				int len = i - left;

				for (int j = 0; j < len / 2; j++) {
					char tmp = chs[left + j];
					chs[left + j] = chs[left + len - j - 1];
					chs[left + len - j - 1] = tmp;
				}
				left = i + 1;
			}
		}
		int len = chs.length - left;

		for (int j = 0; j < len / 2; j++) {
			char tmp = chs[left + j];
			chs[left + j] = chs[left + len - j - 1];
			chs[left + len - j - 1] = tmp;
		}

		return new String(chs);
	}
}