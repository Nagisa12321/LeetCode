package com.leetcode.algorithm.No5786;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/13 11:19
 */
public class Solution {
	public int maximumRemovals(String s, String p, int[] removable) {
		boolean[] del = new boolean[s.length()];
		for (int i = 0; i < removable.length; i++) {
			del[removable[i]] = true;
			if (!isSubStr(del, s, p)) return i;
		}
		return removable.length;
	}

	// 判断p是否为s子序列
	public boolean isSubStr(boolean[] del, String s, String p) {
		char[] chs_s = s.toCharArray();
		char[] chs_p = p.toCharArray();
		int i = 0, j = 0;
		while (i < chs_s.length && j < chs_p.length) {
			if (!del[i] && chs_s[i] == chs_p[j]) {
				j++;
			}
			i++;
		}
		return j == chs_p.length;
	}
}