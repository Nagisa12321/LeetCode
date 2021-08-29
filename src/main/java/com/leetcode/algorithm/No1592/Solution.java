package com.leetcode.algorithm.No1592;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/27 12:29
 */
public class Solution {
	public String reorderSpaces(String text) {
		char[] chs = text.toCharArray();
		int space = 0;
		int reading = 0;
		boolean startWithWord = false;
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == ' ') space++;
			else {
				if (i == 0) startWithWord = true;
				else if (!startWithWord) reading = reading == 0 ? i : reading;
			}
		}

		text = text.substring(reading);
		StringBuilder builder = new StringBuilder();
		String[] strs = text.split("\\s++");
		int len = strs.length;

		if (len == 1) return strs[0] + " ".repeat(space);

		int end = space % (len - 1);
		space /= (len - 1);

		for (int i = 0; i < len; i++) {
			builder.append(strs[i]);
			if (i == len - 1) {
				builder.append(" ".repeat(end));
			} else {
				builder.append(" ".repeat(space));
			}
		}

		return builder.toString();
	}
}