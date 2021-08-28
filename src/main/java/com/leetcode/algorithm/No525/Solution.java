package com.leetcode.algorithm.No525;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/3 9:39
 */

// time out
public class Solution {
	public int findMaxLength(int[] nums) {
		int[] sum = new int[nums.length];
		int zero = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) sum[i] = ++zero;
			else sum[i] = zero;
		}

		int max = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int len = j - i + 1;
				if ((len & 1) == 0) {
					int num = sum[j] - sum[i];
					if (nums[i] == 0) num++;
					if (num * 2 == len) {
						max = Math.max(max, len);
					}
				}
			}
		}
		return max;
	}
}