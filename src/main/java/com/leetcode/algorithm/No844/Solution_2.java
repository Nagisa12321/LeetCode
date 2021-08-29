package com.leetcode.algorithm.No844;

public class Solution_2 {
	public boolean backspaceCompare(String S, String T) {
		StringBuilder theBuilder_S = new StringBuilder();
		StringBuilder theBuilder_T = new StringBuilder();
		int numofJump = 0;
		for (int i = S.length() - 1; i >= 0; i--) {
			if (S.charAt(i) == '#')
				++numofJump;
			else {
				if (numofJump == 0)
					theBuilder_S.append(S.charAt(i));
				else
					--numofJump;
			}
		}
		numofJump = 0;
		for (int i = T.length() - 1; i >= 0; i--) {
			if (T.charAt(i) == '#')
				++numofJump;
			else {
				if (numofJump == 0)
					theBuilder_T.append(T.charAt(i));
				else
					--numofJump;
			}
		}
		if (theBuilder_S.toString().equals(theBuilder_T.toString()))
			return true;
		else
			return false;
	}
}
