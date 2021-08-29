package com.leetcode.algorithm.No6;

public class Solution {
	public String convert(String s, int numRows) {
		// һ�����
		if (numRows == 0)
			return s;
		int n = 2 * numRows - 2;
		StringBuilder[] rows = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++)
			rows[i] = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int line;
			if (n == 0)
				line = 0;
			else {
				int x = i % n;
				line = Math.min(x, n - x);
			}
			rows[line].append(s.charAt(i));
		}
		String newsString = String.join("", rows);
		return newsString;
	}
}
