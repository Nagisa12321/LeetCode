package com.leetcode.algorithm.No1963;

import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/20 10:22
 */
public class Solution {
	public int minSwaps(String s) {
		char[] chs = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (char ch : chs) {
			if (ch == '[')
				stack.push(ch);
			else
				if (stack.isEmpty() || stack.peek() == ']')
					stack.push(ch);
				else stack.pop();
		}
		int num = stack.size() / 2;
		return num - num / 2;
	}
}