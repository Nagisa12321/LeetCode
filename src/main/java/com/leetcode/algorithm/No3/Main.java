package com.leetcode.algorithm.No3;

import java.util.HashMap;

public class Main {
	public static int lengthOfLongestSubstring(String s) {

		int res = 0;
		if (s.length() == 0)
			return 0;
		HashMap<Character, Integer> theHashMap = new HashMap<>();
		for (int right = 0, left = 0; right < s.length(); right++) {
			if (theHashMap.containsKey(s.charAt(right)))
				left = Math.max(left,theHashMap.get(s.charAt(right)) + 1);
			theHashMap.put(s.charAt(right), right);
			res = Math.max(res, right - left + 1);
		}
		return res;
	}

	public static void main(String[] args) {
		String testString = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(testString));
	}

}
