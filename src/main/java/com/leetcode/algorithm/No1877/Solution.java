package com.leetcode.algorithm.No1877;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/7/20 10:21
 */
public class Solution {
	public int minPairSum(int[] nums) {
		Arrays.sort(nums);
		int left = 0, right = nums.length - 1;
		int max = nums[0] + nums[1];
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[left++] + nums[right--]);
		}
		return max;
	}
}