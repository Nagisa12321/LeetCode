package com.leetcode.algorithm.No930;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/8 12:05
 */
public class Solution {
	public int numSubarraysWithSum(int[] nums, int goal) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i - 1];
		}
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			res += map.getOrDefault(nums[i] + goal, 0);
		}
		return res;
	}
}