package com.leetcode.algorithm.No97;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/28 19:38
 */
public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.equals("")) return s2.equals(s3);
		else if (s2.equals("")) return s1.equals(s3);
		char[] chs1 = s1.toCharArray();
		char[] chs2 = s2.toCharArray();
		char[] chs3 = s3.toCharArray();
		if (chs1.length + chs2.length != chs3.length) return false;
		return isInterleave(chs1, 0, chs2, 0, chs3, 0);
	}

	public boolean isInterleave(char[] chs1, int idx1, char[] chs2, int idx2, char[] chs3, int idx3) {
		if (idx3 == chs3.length) return true;
		else if (idx1 == chs1.length) {
			if (chs2[idx2] != chs3[idx3]) return false;
			return isInterleave(chs1, idx1, chs2, idx2 + 1, chs3, idx3 + 1);
		} else if (idx2 == chs2.length) {
			if (chs1[idx1] != chs3[idx3]) return false;
			return isInterleave(chs1, idx1 + 1, chs2, idx2, chs3, idx3 + 1);
		} else {
			if (chs1[idx1] == chs3[idx3] && chs2[idx2] == chs3[idx3]) {
				return isInterleave(chs1, idx1, chs2, idx2 + 1, chs3, idx3 + 1) ||
						isInterleave(chs1, idx1 + 1, chs2, idx2, chs3, idx3 + 1);
			} else if (chs1[idx1] == chs3[idx3]) {
				return isInterleave(chs1, idx1 + 1, chs2, idx2, chs3, idx3 + 1);
			} else if (chs2[idx2] == chs3[idx3]) {
				return isInterleave(chs1, idx1, chs2, idx2 + 1, chs3, idx3 + 1);
			} else { return false; }
		}
	}
}