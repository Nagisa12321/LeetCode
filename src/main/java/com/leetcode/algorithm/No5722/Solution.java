package com.leetcode.algorithm.No5722;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/4 20:22
 */
public class Solution {
	public String truncateSentence(String s, int k) {
		String[] strs = s.split(" ");
		String result = "";

		for (int i = 0; i < k; i++) {
			result += strs[i];
			if (i != k - 1) result += " ";
		}

		return result;
	}
}