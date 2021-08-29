package com.leetcode.algorithm.No81.array;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/7 14:41
 */
public class Solution {
	public boolean search(int[] nums, int target) {
		int len = nums.length;
		int left = nums[0];
		int right = nums[len - 1];
		if (left == right || len < 10) {
			for (int num : nums)
				if (num == target) return true;

			return false;
		} else if (left > right) {
			// 先找出旋转点下标
			int lo = 0, hi = len - 1;

			while (lo < hi) {
				int mid = lo + (hi - lo) / 2;
				if (mid == 0 || mid == len - 1 || (nums[mid] <= nums[mid + 1] && nums[mid] < nums[mid - 1])) {
					lo = mid;
					break;
				} else if (nums[mid] >= left) lo = mid + 1;
				else hi = mid - 1;
			}
			int idx = lo;
			lo = 0;
			hi = len - 1;
			while (lo <= hi) {
				int realLo = (lo + idx) % len;
				int realMid = (realLo + (hi - lo) / 2) % len;
				int mid = lo + (hi - lo) / 2;
				if (nums[realMid] == target) return true;
				else if (nums[realMid] < target) lo = mid + 1;
				else hi = mid - 1;
			}

			return false;
		} else {
			int lo = 0, hi = len - 1;
			while (lo <= hi) {
				int mid = lo + (hi - lo) / 2;
				if (nums[mid] == target) return true;
				else if (nums[mid] < target) lo = mid + 1;
				else hi = mid - 1;
			}
			return false;
		}
	}
}