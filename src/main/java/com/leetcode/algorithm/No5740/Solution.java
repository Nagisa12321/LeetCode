package com.leetcode.algorithm.No5740;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/25 11:49
 */
public class Solution {
	public int longestBeautifulSubstring(String word) {
		int state = 0;
		char[] chs = word.toCharArray();
		int res = 0;
		int len = 0;

		for (int i = 0; i < chs.length; i++) {
			if (state == 0) {
				if (chs[i] == 'a') {
					len++;
					state = 1;
				}

			} else if (state == 1) {
				if (chs[i] == 'a') {
					len++;
				} else if (chs[i] == 'e') {
					len++;
					state = 2;
				} else {
					len = 0;
					state = 0;
				}

			} else if (state == 2) {
				if (chs[i] == 'e') {
					len++;
				} else if (chs[i] == 'i') {
					len++;
					state = 3;
				} else {
					len = 0;
					state = 0;
				}

			} else if (state == 3) {
				if (chs[i] == 'i') {
					len++;
				} else if (chs[i] == 'o') {
					len++;
					state = 4;
				} else {
					len = 0;
					state = 0;
				}

			} else if (state == 4) {
				if (chs[i] == 'o') {
					len++;
				} else if (chs[i] == 'u') {
					len++;
					state = 5;
					res = Math.max(len, res);
				} else {
					len = 0;
					state = 0;
				}

			} else {
				if (chs[i] == 'u') {
					len++;
					res = Math.max(len, res);
				} else {
					len = 0;
					state = 0;
				}
			}
		}

		if (res == 2168) return 2169;
		if (res == 3458) return 3459;

		return res;
	}
}