package com.leetcode.algorithm.No1047;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/27 22:18
 */
public class Solution {
	public String removeDuplicates(String S) {
		char[] chs = S.toCharArray();
		char[] stack = new char[20000];
		int idx = 0;

		for (char ch : chs) {
			if (idx == 0 || stack[idx - 1] != ch) stack[idx++] = ch;
			else while (idx != 0 && stack[idx - 1] == ch) idx--;
		}

		return new String(stack, 0, idx);
	}
}