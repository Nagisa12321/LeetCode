package com.leetcode.algorithm.No90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/31 13:56
 */
public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		track(result, new ArrayList<>(), nums, 0);

		return result;
	}

	private void track(List<List<Integer>> result, List<Integer> list, int[] nums, int idx) {
		result.add(new ArrayList<>(list));

		if (idx >= nums.length) return;

		int[] map = new int[21];
		for (int i = idx; i < nums.length; i++) {
			if (map[nums[i] + 10] != 0) continue;
			map[nums[i] + 10]++;

			list.add(nums[i]);
			track(result, list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}
}