package com.leetcode.algorithm.No494;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/7 14:46
 */
public class Solution2 {
	public int findTargetSumWays(int[] nums, int target) {
		// 让目标为.. 有.. 种方法
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(nums[0], 1);
		map.put(-nums[0], 1);
		for (int i = 1; i < nums.length; i++) {
			HashMap<Integer, Integer> tmp = new HashMap<>();
			for (int key : map.keySet()) {
				tmp.put(key - nums[i], tmp.getOrDefault(key - nums[i], 0) + map.get(key));
				tmp.put(key + nums[i], tmp.getOrDefault(key + nums[i], 0) + map.get(key));
			}
			map = tmp;
		}
		return map.get(target);
	}
}