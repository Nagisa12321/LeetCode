package com.leetcode.algorithm.No20;

import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {
		if(s.length() % 2 == 1)
			return false;
		Stack<Character> theStack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (!theStack.isEmpty()) {
				if (isTheSameSymbol(s.charAt(i), theStack.peek().charValue()))
					theStack.pop();
				else if (isTheSameDirection(s.charAt(i), theStack.peek().charValue()))
					theStack.push(s.charAt(i));
				else
					return false;
			} else if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				theStack.push(s.charAt(i));
			} else {
				return false;
			}
		}
		if (theStack.isEmpty())
			return true;
		else
			return false;
	}

	public boolean isTheSameDirection(char a, char b) {
		if ((a == '(' || a == '[' || a == '{') && (b == '(' || b == '[' || b == '{'))
			return true;
		else
			return false;
	}

	public boolean isTheSameSymbol(char a, char b) {
		if (a == ')' && b == '(')
			return true;
		else if (a == ']' && b == '[')
			return true;
		else if (a == '}' && b == '{')
			return true;
		else
			return false;
	}
}
