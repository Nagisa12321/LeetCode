package com.leetcode.algorithm.No633;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/28 0:39
 */
public class Solution {
	public boolean judgeSquareSum(int c) {
		if (c == 0) return true;
		int sqrtMax = (int) Math.sqrt(Integer.MAX_VALUE);
		for (int i = 0; i * i < c && i < sqrtMax; i++) {
			double tmp = Math.sqrt(c - i * i);
			if (tmp == (int) tmp) return true;
		}

		return false;
	}
}