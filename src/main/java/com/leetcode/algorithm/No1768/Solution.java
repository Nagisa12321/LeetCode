package com.leetcode.algorithm.No1768;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/5 1:59
 */
public class Solution {
	public String mergeAlternately(String word1, String word2) {
		char[] chs1 = word1.toCharArray();
		char[] chs2 = word2.toCharArray();

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < Math.max(chs1.length, chs2.length); i++) {
			builder.append(i < chs1.length ? chs1[i] : "");
			builder.append(i < chs2.length ? chs2[i] : "");
		}

		return builder.toString();
	}
}