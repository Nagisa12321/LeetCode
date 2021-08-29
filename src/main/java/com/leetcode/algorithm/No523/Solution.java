package com.leetcode.algorithm.No523;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/2 10:07
 */
public class Solution {
	public boolean checkSubarraySum(int[] nums, int k) {
		int[] map = new int[k];
		int sum = 0;
		for (int i = 0; i < k; i++)
			map[i] = -2;
		map[0] = -1;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int rmd = sum % k;

			if (map[rmd] != -2) {
				int idx = map[rmd];
				if (i - idx >= 2) return true;
			} else {
				map[rmd] = i;
			}
		}

		return false;
	}
}