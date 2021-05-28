package com.leetcode.algorithm.No377;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/24 8:53
 */
public class Solution {
	private Map<Integer, Integer> map;
	public int combinationSum4(int[] nums, int target) {
		map = new HashMap<>();
		return combinationSum4(nums, target, 0);
	}

	private int combinationSum4(int[] nums, int target, int now) {
		if (now > target) return 0;
		else if (now == target) {
			return 1;
		}

		if (map.containsKey(now)) return map.get(now);
		int res = 0;
		for (int num : nums) {
			res += combinationSum4(nums, target, now + num);
		}
		map.put(now, res);
		return res;
	}
}