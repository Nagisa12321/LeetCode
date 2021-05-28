package com.leetcode.algorithm.No1190;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/26 9:25
 */
public class Solution {
	public String reverseParentheses(String s) {
		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new LinkedList<>();
		char[] chs = s.toCharArray();

		for (char ch : chs) {
			if (ch == ')') {
				while (true) {
					char tmp = stack.pop();
					if (tmp == '(') break;
					queue.offer(tmp);
				}
				while (!queue.isEmpty()) {
					stack.push(queue.poll());
				}
			} else { stack.push(ch); }
		}

		StringBuilder builder = new StringBuilder();
		while (!stack.isEmpty()) {
			builder.append(stack.pop());
		}

		return builder.reverse().toString();
	}
}