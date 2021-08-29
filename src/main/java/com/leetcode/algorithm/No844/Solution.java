package com.leetcode.algorithm.No844;

public class Solution {
	public boolean backspaceCompare(String S, String T) {
		StringBuilder theBuilder_S = new StringBuilder();
		StringBuilder theBuilder_T = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '#') {
				if (theBuilder_S.length() != 0) {
					theBuilder_S.deleteCharAt(theBuilder_S.length()-1);
				}
			} else
				theBuilder_S.append(S.charAt(i));
		}
		for (int i = 0; i < T.length(); i++) {
			if (T.charAt(i) == '#') {
				if (theBuilder_T.length() != 0) {
					theBuilder_T.deleteCharAt(theBuilder_T.length()-1);
				}
			} else
				theBuilder_T.append(T.charAt(i));
		}
		if (theBuilder_S.toString().equals(theBuilder_T.toString()))
			return true;
		else
			return false;
	}
}
