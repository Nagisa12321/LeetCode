package com.leetcode.algorithm.No5734;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/18 10:43
 */
public class Solution {
	public boolean checkIfPangram(String sentence) {
		char[] chs = sentence.toCharArray();
		int[] map = new int[26];
		for (char ch : chs) {
			if (ch <= 'z' && ch >= 'a') {
				map[ch - 'a']++;
			}
		}
		for (int i = 0; i < 26; i++) {
			if (map[i] == 0) return false;
		}

		return true;
	}
}