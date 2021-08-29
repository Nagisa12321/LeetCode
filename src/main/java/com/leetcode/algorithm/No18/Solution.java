package com.leetcode.algorithm.No18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/16 14:19
 */
public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		int len = nums.length;
		List<List<Integer>> result = new ArrayList<>();
		if (len < 4) return result;
		Arrays.sort(nums);

		for (int i = 0; i < len - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			for (int j = i + 1; j < len - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) continue;

				int twoSumTarget = target - nums[i] - nums[j];
				int left = j + 1, right = len - 1;
				while (left < right) {
					int nums_left = nums[left];
					int nums_right = nums[right];
					if (nums_left + nums_right < twoSumTarget) left++;
					else if (nums_left + nums_right > twoSumTarget) right--;
					else {
						result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums_left, nums_right)));

						left++;
						right--;
						while (left < right && nums[left] == nums[left - 1]) left++;
						while (left < right && nums[right] == nums[right + 1]) right--;
					}
				}
			}
		}

		return result;
	}
}