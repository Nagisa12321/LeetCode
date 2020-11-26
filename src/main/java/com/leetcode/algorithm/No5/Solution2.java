package com.leetcode.algorithm.No5;

public class Solution2 {
    	public boolean isRound(String theString) {
		StringBuffer theBuffer = new StringBuffer(theString);
		if(theBuffer.toString().equals(theBuffer.reverse().toString())) {
			return true;
		}
		else return false;
	}
    public String longestPalindrome(String s) {
        String theString = null;
		int length = s.length();
		int maxLength = 0;
		for (int left = 0; left < length; left++) {
			for (int right = left; right < length; right++) {
				if (s.charAt(right) == s.charAt(left)) {
					if ((right - left + 1) > maxLength&&isRound(s.substring(left,right+1))) {
						maxLength = right - left + 1;
						theString = s.substring(left, right + 1);
					}
				}
			}
		}
		System.out.println(maxLength);
        return theString;
    }
}
