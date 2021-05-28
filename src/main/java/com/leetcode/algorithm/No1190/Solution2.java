package com.leetcode.algorithm.No1190;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/26 9:34
 */
public class Solution2 {
	public String reverseParentheses(String s) {
		char[] stack = new char[2000];
		int stack_idx = 0;
		char[] queue = new char[2000];
		int queue_idx = 0;
		char[] chs = s.toCharArray();

		for (char ch : chs) {
			if (ch == ')') {
				while (true) {
					char tmp = stack[--stack_idx];
					if (tmp == '(') break;
					queue[queue_idx++] = tmp;
				}
				for (int i = 0; i < queue_idx; i++) {
					stack[stack_idx++] = queue[i];
				}
				queue_idx = 0;
			} else { stack[stack_idx++] = ch; }
		}
		char[] result = new char[stack_idx];
		int idx = 0;
		for (int i = 0; i < stack_idx; i++) {
			result[i] = stack[idx++];
		}
		return new String(result);
	}
}