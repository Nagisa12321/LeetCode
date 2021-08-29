package com.leetcode.algorithm.No1961;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/20 10:02
 */
public class Solution {
	public boolean isPrefixString(String s, String[] words) {
		char[] chs = s.toCharArray();
		int idx = 0;
		for (String word : words) {
			if (idx == chs.length)
				return true;
			for (int j = 0; j < word.length(); j++) {
				if (idx == chs.length)
					return false;
				if (word.charAt(j) != chs[idx++])
					return false;
			}
		}
		return idx == chs.length;
	}
}