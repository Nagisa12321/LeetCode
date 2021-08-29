package com.leetcode.algorithm.No345;

import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/25 15:10
 */
public class Solution {
	public String reverseVowels(String s) {
		Stack<Character> stack = new Stack<>();

		char[] chs = s.toCharArray();
		for (char ch : chs) {
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
					ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ) {
				stack.push(ch);
			}
		}

		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == 'a' || chs[i] == 'e' || chs[i] == 'o' || chs[i] == 'i' || chs[i] == 'u' ||
					chs[i] == 'A' || chs[i] == 'E' || chs[i] == 'I' || chs[i] == 'O' || chs[i] == 'U') {
				chs[i] = stack.pop();
			}
		}

		return new String(chs);
	}
}