package com.leetcode.interview.No1.No6;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/26 23:24
 */
public class Solution {
	public String compressString(String S) {
		if (S.equals(""))  return "";
		char[] chs = S.toCharArray();
		StringBuilder builder = new StringBuilder();
		int num = 1;
		for (int i = 1; i < chs.length; i++) {
			if (chs[i] != chs[i - 1]) {
				builder.append(chs[i - 1]).append(num);
				num = 1;
			} else {
				num++;
			}
		}
		builder.append(chs[chs.length - 1]).append(num);
		String result = builder.toString();
		return result.length() < S.length() ? result : S;
	}
}