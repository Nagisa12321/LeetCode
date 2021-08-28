package com.leetcode.algorithm.No1663;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/4 12:25
 */
public class Solution {
	public String getSmallestString(int n, int k) {
		if (n == 1) return String.valueOf((char) ('a' + k - 1));

		int i = k - (n - 1) * 26;
		if (i <= 0) i = 1;
		return (char) ('a' + i - 1) + getSmallestString(n - 1, k - i);
	}
}