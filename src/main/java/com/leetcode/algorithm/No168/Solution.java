package com.leetcode.algorithm.No168;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/4 21:12
 */
public class Solution {
	public String convertToTitle(int columnNumber) {
		StringBuilder builder = new StringBuilder();
		while (columnNumber-- > 0) {
			builder.append((char) (columnNumber % 26 + 'A'));
			columnNumber /= 26;
		}
		return builder.reverse().toString();
	}
}