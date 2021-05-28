package com.leetcode.algorithm.No5739;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/25 11:13
 */
public class Solution {
	public int maxFrequency(int[] nums, int k) {
		Arrays.sort(nums);
		int len = nums.length;

		// diff每一项代表和前一项的差值
//		int[] diff = new int[len];
//		diff[0] = k;
//
//		for (int i = 1; i < len; i++) {
//			diff[i] = nums[i] - nums[i - 1];
//		}

		int res = 0;
		for (int i = 0; i < len; i++) {
			int pay = 0;
			int idx = i;
			int num = 0;
			while (idx >= 0 && pay <= k) {
				pay += nums[i] - nums[idx];
				num++;
				idx--;
			}
			if (pay <= k)
				res = Math.max(res, num);
			else res = Math.max(res, num - 1);
		}

		return res;
	}
}