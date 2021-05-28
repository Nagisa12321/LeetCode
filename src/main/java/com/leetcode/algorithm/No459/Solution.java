package com.leetcode.algorithm.No459;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/21 13:15
 */
public class Solution {
	public boolean repeatedSubstringPattern(String s) {
		char[] chs = s.toCharArray();
		int len = chs.length;

		// if (len % 2 == 1) return false;
		for (int i = 0; i < (len % 2 == 0 ? len / 2 : (len / 2 - 1 == 0 ? 1 : len / 2 - 1)); i++) {
			if (repeatedSubstringPattern(i, chs)) return true;
		}

		return false;
	}

	public boolean repeatedSubstringPattern(int idx, char[] chs) {
		int len = idx + 1;
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] != chs[i % len]) return false;
		}
		return true;
	}
}