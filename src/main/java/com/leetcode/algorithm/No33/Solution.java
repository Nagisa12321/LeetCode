package com.leetcode.algorithm.No33;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/8/18 11:34
 */
public class Solution {
	public int search(int[] nums, int target) {
		int be = 0;
		int len = nums.length;
		if (nums[0] > nums[len - 1]) {
			int lo = 0, hi = len - 1;
			while (lo <= hi) {
				int mid = lo + (hi - lo) / 2;
				if (nums[mid] > nums[0]) {
					lo = mid + 1;
				} else if (nums[mid - 1] < nums[mid]) {
					hi = mid - 1;
				} else {
					be = mid;
					break;
				}
			}
		}

		int vlo = 0, vhi = len - 1;
		while (vlo <= vhi) {
			int vmid = vlo + (vhi - vlo) / 2;
			int mid = p(vmid, be, len);
			if (nums[mid] < target) {
				vlo = vmid + 1;
			} else if (nums[mid] > target) {
				vhi = vmid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	private int p(int v, int be, int len) {
		return v - be < 0 ? v + len - be : v - be;
	}
}