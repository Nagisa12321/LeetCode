package com.leetcode.algorithm.No220;

import java.util.TreeSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/18 13:41
 */
public class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums.length == 0) return false;
		TreeSet<Long> set = new TreeSet<>();
		for (int i = 0; i <= Math.min(k, nums.length - 1); i++) {
			int x = nums[i];
			if (test(t, set, x)) return true;
		}

		int idx = k + 1;
		while (true) {
			set.remove((long) nums[idx - k - 1]);

			if (idx >= nums.length) break;
			int x = nums[idx];
			if (test(t, set, x)) return true;

			idx++;
		}


		return false;
	}

	private boolean test(int t, TreeSet<Long> set, int x) {
		Long ceiling = set.ceiling((long) x);
		Long floor = set.floor((long) x);

		if (ceiling != null && Math.abs(x - ceiling) <= t) return true;
		if (floor != null && Math.abs(x - floor) <= t) return true;
		set.add((long) x);
		return false;
	}
}