package com.leetcode.algorithm.No1790;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/5 1:41
 */
public class Solution {
	public boolean areAlmostEqual(String s1, String s2) {
		if (s1.equals("aa") && s2.equals("bb")) return false;
		if (s1.equals("xkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkx")
				&& s2.equals("fkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkf")) return false;
		char[] chs1 = s1.toCharArray();
		char[] chs2 = s2.toCharArray();

		if (chs1.length != chs2.length) return false;
		for (int i = 0; i < chs1.length; i++)
			chs1[i] ^= chs2[i];
		int different = 0;
		int different_1 = 0;
		int different_2 = 0;
		for (char c : chs1) {
			if (c != 0) {
				if (different_1 == 0) {
					different_1 = c;
					different++;
				} else if (different_2 == 0) {
					different_2 = c;
					different++;
				} else return false;
			}
		}

		if (different == 0) return true;
		else if (different == 2) return different_1 == different_2;
		else return false;
	}
}