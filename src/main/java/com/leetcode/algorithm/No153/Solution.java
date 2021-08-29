package com.leetcode.algorithm.No153;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/14 16:18
 */
public class Solution {
	public int findMin(int[] nums) {
		int lo = 0, hi = nums.length - 1;
		int left = nums[lo], right = nums[hi];
		if (left <= right) return left;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] <= right && nums[mid - 1] > right) return nums[mid];
			else if (nums[mid] > right) lo = mid + 1;
			else hi = mid - 1;
		}

		return nums[0];
	}
}