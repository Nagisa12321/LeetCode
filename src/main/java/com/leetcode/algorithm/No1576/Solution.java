package com.leetcode.algorithm.No1576;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 11:52
 */
public class Solution {
	public String modifyString(String s) {
		char[] chs = s.toCharArray();
		int len = chs.length;
		for (int i = 0; i < len; i++) {
			if (chs[i] == '?') {
				for (int j = 'a'; j <= 'z'; j++) {
					if ((i + 1 == len || chs[i + 1] != j) && (i == 0 || chs[i - 1] != j)) {
						chs[i] = (char) j;
						break;
					}
				}
			}
		}

		return new String(chs);
	}
}
