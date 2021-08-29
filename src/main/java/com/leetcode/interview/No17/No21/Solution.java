package com.leetcode.interview.No17.No21;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/3 12:33
 */
public class Solution {
	public int trap(int[] height) {
		int len = height.length;
		int[] stack = new int[len * 2];
		int idx = 0;
		int water = 0;

		for (int i = 0; i < len; i++) {
			int last_height = 0;
			int last_idx = 0;
			while (idx != 0 && stack[idx - 1] <= height[i]) {
				last_height = stack[--idx];
				last_idx = stack[--idx];
			}

			if (last_idx != 0) {
				water += (height[i] - last_height) * (i - last_idx - 1);
			}

			stack[idx++] = i;
			stack[idx++] = height[i];
		}

		return water;
	}
}