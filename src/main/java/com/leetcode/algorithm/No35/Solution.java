package com.leetcode.algorithm.No35;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 14:18
 */
public class Solution {
	public int searchInsert(int[] nums, int target) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (target <= nums[i])
				return i;
		}

		return len;
	}
}