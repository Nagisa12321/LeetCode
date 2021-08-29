package com.leetcode.algorithm.No1119;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/23 9:31
 */
public class Solution {
	public String removeVowels(String s) {
		char[] chs = s.toCharArray();
		int len = chs.length;
		char[] tmp = new char[len];
		int size = 0;

		for (char ch : chs) {
			if (!isAEIOU(ch)) tmp[size++] = ch;
		}

		char[] res = new char[size];
		if (size >= 0) System.arraycopy(tmp, 0, res, 0, size);

		return new String(res);
	}

	private boolean isAEIOU(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
}