package com.leetcode.algorithm.No503;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/26 16:01
 */
public class Solution {
	public int[] nextGreaterElements(int[] nums) {
		// 单调栈
		// 存储方式: 先存下标, 然后存对应值
		int[] stack = new int[10001];
		int[] result = new int[nums.length];
		Arrays.fill(result, -1);
		int stack_idx = 0;
		// 因为是循环数组, 因此遍历两次
		for (int i = 0; i < nums.length; i++) {
			while (stack_idx != 0 && stack[stack_idx - 1] < nums[i]) {
				// 出栈两个
				stack_idx -= 2;
				int idx = stack[stack_idx];
				result[idx] = i;
			}
			// 存进去两个
			stack[stack_idx++] = i;
			stack[stack_idx++] = nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			while (stack_idx != 0 && stack[stack_idx - 1] < nums[i]) {
				// 出栈两个
				stack_idx -= 2;
				int idx = stack[stack_idx];

				if (result[idx] == -1)
					result[idx] = i;
			}
			// 存进去两个
			stack[stack_idx++] = i;
			stack[stack_idx++] = nums[i];
		}
		// 取出最大的一个/几个进行赋值为-1
		for (int i = 0; i < result.length; i++) {
			if (result[i] == -1) continue;

			result[i] = nums[result[i]];
		}
		return result;
	}
}