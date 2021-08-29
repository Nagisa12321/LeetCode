package com.leetcode.algorithm.No80;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/25 15:03
 */
public class Solution {
	public int removeDuplicates(int[] nums) {
		int idx = 0;
		int num = 1;
		int now = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == now) {
				if (num <= 2) {
					nums[idx++] = nums[i];
				}
				num++;
			} else {
				num = 2;
				now = nums[i];
				nums[idx++] = nums[i];
			}
		}
		return idx;
	}
}