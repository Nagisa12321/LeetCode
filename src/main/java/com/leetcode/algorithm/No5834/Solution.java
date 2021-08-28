package com.leetcode.algorithm.No5834;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/22 10:27
 */
public class Solution {
	public int minTimeToType(String word) {
		char[] chs = word.toCharArray();
		char last = 'a';
		int second = chs.length;
		for (char ch : chs) {
			int tmp = Math.abs(ch - last);
			second += Math.min(tmp, 26 - tmp);
			last = ch;
		}
		return second;
	}
}