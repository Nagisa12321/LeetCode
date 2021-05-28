package com.leetcode.algorithm.No139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/19 16:29
 */
public class Solution {
	public boolean wordBreak(String s, List<String> wordDict) {
		int min = wordDict.get(0).length();
		for (String s1 : wordDict) {
			min = Math.min(s1.length(), min);
		}
		HashSet<String> set = new HashSet<>(wordDict);
		return wordBreak(s, set, min);
	}

	private boolean wordBreak(String s, Set<String> set, int min) {
		if (s.length() < min) return false;
		for (int i = s.length(); i >= 0; i--) {
			String sub = s.substring(i);
			if (set.contains(sub)) {
				if (i == 0) return true;
				else if (wordBreak(s.substring(0, i), set, min)) return true;
			}
		}
		return false;
	}
}