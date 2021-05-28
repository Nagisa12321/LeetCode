package com.leetcode.algorithm.No263;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/10 13:35
 */
public class Solution {
	public boolean isUgly(int n) {
		if (n == 0) return false;
		if (n == 1) return true;
		else if (n == 2 || n == 3 || n == 5) return true;
		boolean result = false;

		if (n % 2 == 0) result = isUgly(n / 2);
		if (n % 3 == 0) result = result || isUgly(n / 3);
		if (n % 5 == 0) result = result || isUgly(n / 5);

		return result;
	}
}