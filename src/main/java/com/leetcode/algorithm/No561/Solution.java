package com.leetcode.algorithm.No561;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/12 13:44
 */
public class Solution {
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);

		int sum = 0;
		int len = nums.length;
		for (int i = 0; i < len - 1; i += 2) {
			sum += nums[i];
		}

		return sum;
	}
}