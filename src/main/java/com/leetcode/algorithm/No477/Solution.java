package com.leetcode.algorithm.No477;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/28 9:47
 */
public class Solution {
	public int totalHammingDistance(int[] nums) {
		int result = 0;
		int len = nums.length;
		for (int i = 0; i < 32; i++) {
			int cur = 0;
			for (int num : nums) {
				cur += (num >> i) & 1;
			}
			result += cur * (len - cur);
		}
		return result;
	}
}