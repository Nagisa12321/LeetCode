package com.leetcode.algorithm.No65;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/17 10:18
 */
public class Solution {
	public boolean isNumber(String s) {
		char[] chs = s.toCharArray();
		int state = 0;
		for (char ch : chs) {
			switch(state) {
				case 0:
					if (isNumber(ch)) {
						state = 1;
					} else if (isPoint(ch)) {
						state = 2;
					} else if (isOperation(ch)) {
						state = 4;
					} else return false;
					break;
				case 1:
					if (isNumber(ch)) {
						state = 1;
					} else if (isPoint(ch)) {
						state = 2;
					} else return false;
					break;
				case 2:
					if (isE(ch)) {
						state = 8;
					} else if (isNumber(ch)) {
						state = 3;
					} else return false;
					break;
				case 3:
					if (isNumber(ch)) {
						state = 3;
					} else if (isE(ch)) {
						state = 8;
					} else return false;
					break;
				case 4:
					if (isNumber(ch)) {
						state = 1;
					} else if (isPoint(ch)) {
						state = 2;
					} else return false;
					break;
				case 5:
					if (isNumber(ch)) {
						state = 7;
					} else if (isOperation(ch)) {
						state = 6;
					} else return false;
					break;
				case 6:
					if (isNumber(ch)) {
						state = 7;
					} else return false;
					break;
				case 7:
					if (isNumber(ch)) {
						state = 7;
					} else if (isPoint(ch)) {
						state = 2;
					} else return false;
					break;
				case 8:
					if (isOperation(ch)) {
						state = 9;
					} else if (isNumber(ch)) {
						state = 10;
					} else return false;
					break;
				case 9:
					if (isNumber(ch)) {
						state = 10;
					} else return false;
					break;
				case 10:
					if (isNumber(ch)) {
						state = 10;
					} else return false;
					break;
			}
		}
		return state == 1 || state == 2 || state == 3 || state == 7 || state == 10;
	}

	private boolean isNumber(char ch) {
		return ch >= '0' && ch <= '9';
	}

	private boolean isE(char ch) {
		return ch == 'e' || ch == 'E';
	}

	private boolean isOperation(char ch) {
		return ch == '+' || ch == '-';
	}

	private boolean isPoint(char ch) {
		return ch == '.';
	}
}