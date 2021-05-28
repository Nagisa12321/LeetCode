package com.leetcode.binarysearchtree.No3.No3;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/8 11:22
 */
public class Solution {
	// ³¬Ê±
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (j - i > k) break;
				if (Math.abs((long) nums[i] - (long) nums[j]) <= t)
					return true;
			}
		}

		return false;
	}
}