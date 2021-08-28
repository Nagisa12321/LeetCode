package com.leetcode.algorithm.No231;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/30 11:29
 */
public class Solution {
	public boolean isPowerOfTwo(int n) {
		if (n <= 0) return false;
		else if (n <= 2) return true;
		return (n & 1) != 1 && isPowerOfTwo(n >> 1);
	}
}