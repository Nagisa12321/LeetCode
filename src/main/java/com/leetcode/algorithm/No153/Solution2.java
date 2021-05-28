package com.leetcode.algorithm.No153;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/14 16:19
 */
public class Solution2 {
	public int findMin(int[] nums) {
		int lo = 0, hi = nums.length - 1;
		int left = nums[lo], right = nums[hi];
		if (left <= right) return left;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] > right) lo = mid + 1;
			else hi = mid;
		}

		return nums[lo];

	}
}
