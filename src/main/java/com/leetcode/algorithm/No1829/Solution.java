package com.leetcode.algorithm.No1829;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/21 14:10
 */
public class Solution {
	public int[] getMaximumXor(int[] nums, int maximumBit) {
		int[] bits = new int[maximumBit];
		for (int num : nums) {
			for (int j = 0; j < maximumBit; j++) {
				bits[maximumBit - j - 1] += (num >> j) & 1;
			}
		}
		int[] res = new int[nums.length];
		for (int i = 0; i < res.length; i++) {
			int num = 0;
			for (int j = 0; j < maximumBit; j++) {
				if (bits[j] % 2 == 0) {
					num += 1;
				}
				if (j != maximumBit - 1)
					num <<= 1;
			}
			res[i] = num;
			int del = nums[nums.length - 1 - i];
			for (int j = 0; j < maximumBit; j++) {
				if ((del & 1) == 1)
					bits[maximumBit- j - 1]--;
				del >>= 1;
			}
		}
		return res;
	}
}