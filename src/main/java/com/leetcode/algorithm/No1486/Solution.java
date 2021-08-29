package com.leetcode.algorithm.No1486;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/7 0:12
 */
public class Solution {
	public int xorOperation(int n, int start) {
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = start + i * 2;
		}
		int result = nums[0];
		for (int i = 1; i < n; i++) {
			result ^= nums[i];
		}
		return result;
	}
}