package com.leetcode.algorithm.No7;

public class Solution {
	public int reverse(int x) {
		String theString;
		if (x >= 0) {
			theString = new StringBuilder(new String(x + "")).reverse().toString();
		} else {
			theString = new StringBuilder(new String(x + "").substring(1)).append("-").reverse().toString(); 
		}
		if (Double.parseDouble(theString) < -Math.pow(2, 31) || Double.parseDouble(theString) > (Math.pow(2, 31) - 1))
			return 0;
		else
		return Integer.parseInt(theString);
	}
}
