package com.leetcode.algorithm.No1967;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/20 21:49
 */
public  class Solution {
	public int numOfStrings(String[] patterns, String word) {
		char[] chs = word.toCharArray();
		int res = 0;
		for (String pattern : patterns) {
			if (isChild(pattern, chs))
				res++;
		}
		return res;
	}

	public boolean isChild(String s, char[] chs) {
		char[] tmp = s.toCharArray();
		if (tmp.length > chs.length)
			return false;
		for (int i = 0; i < chs.length; i++) {
			if (isChild(tmp, chs, i))
				return true;
		}
		return false;
	}

	public boolean isChild(char[] tmp, char[] chs, int idx) {
		for (int i = 0; i < tmp.length; i++) {
			if (idx + i >= chs.length)
				return false;
			if (tmp[i] != chs[idx + i])
				return false;
		}
		return true;
	}
}