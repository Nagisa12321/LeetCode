package com.leetcode.queueorstack.summary.No3;

import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/3 11:43
 */
public class Solution {
	public String decodeString(String s) {
		Stack<Integer> numStack = new Stack<>();
		Stack<String> strStack = new Stack<>();

		char[] chs = s.toCharArray();
		int num = 0;

		for (char ch : chs) {
			if (ch >= '0' && ch <= '9')
				num = num * 10 + (ch - '0');
			else if (ch == '[') {
				numStack.push(num);
				num = 0;
				strStack.push("[");
			} else if (ch == ']') {
				StringBuilder builder = new StringBuilder();
				while (true) {
					String tmp = strStack.pop();
					if (tmp.equals("[")) break;
					else builder.append(tmp);
				}
				int times = numStack.pop();
				builder.append(builder.toString().repeat(times - 1));
				strStack.push(builder.toString());
			} else strStack.push(String.valueOf(ch));
		}

		StringBuilder builder = new StringBuilder();
		while (!strStack.isEmpty()) {
			builder.append(strStack.pop());
		}

		return builder.reverse().toString();
	}
}
