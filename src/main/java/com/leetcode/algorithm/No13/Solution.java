package com.leetcode.algorithm.No13;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/15 9:11
 */
public class Solution {
	public int romanToInt(String s) {
		int result = 0;
		char[] chs = s.toCharArray();

		for (int i = 0; i < chs.length; i++) {
			switch(chs[i]) {
				case 'I':
					result += 1;
					break;
				case 'V':
					if (i != 0 && chs[i - 1] == 'I') {
						result += 3;
					} else {
						result += 5;
					}
					break;
				case 'X':
					if (i != 0 && chs[i - 1] == 'I') {
						result += 8;
					} else {
						result += 10;
					}
					break;
				case 'L':
					if (i != 0 && chs[i - 1] == 'X') {
						result += 30;
					} else {
						result += 50;
					}
					break;
				case 'C':
					if (i != 0 && chs[i - 1] == 'X') {
						result += 80;
					} else {
						result += 100;
					}
					break;
				case 'D':
					if (i != 0 && chs[i - 1] == 'C') {
						result += 300;
					} else {
						result += 500;
					}
					break;
				case 'M':
					if (i != 0 && chs[i - 1] == 'C') {
						result += 800;
					} else {
						result += 1000;
					}
					break;
			}
		}
		return result;
	}
}