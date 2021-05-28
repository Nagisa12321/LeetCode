package com.leetcode.algorithm.No35;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 14:19
 */
public class Solution2 {
	public int searchInsert(int[] nums, int target) {
		int len = nums.length;
		int left = 0, right = len - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (target <= nums[mid] && (mid == 0 || target > nums[mid - 1]))
				return mid;
			else if (target > nums[mid]) left = mid + 1;
			else right = mid - 1;
		}

		return len;
	}
}