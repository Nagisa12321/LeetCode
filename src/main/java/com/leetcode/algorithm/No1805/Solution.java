package com.leetcode.algorithm.No1805;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/4 20:30
 */
public  class Solution {
	public int numDifferentIntegers(String word) {
		String[] strs = word.split("[a-z]+");
		HashSet<String> set = new HashSet<>();

		for (String str : strs) {
			if (str.equals("")) continue;
			int cut = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '0') cut++;
				else break;
			}
			set.add(str.substring(cut));
		}

		return set.size();
	}
}