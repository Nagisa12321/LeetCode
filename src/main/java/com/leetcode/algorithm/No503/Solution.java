package com.leetcode.algorithm.No503;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/26 16:01
 */
public class Solution {
	public int[] nextGreaterElements(int[] nums) {
		// ����ջ
		// �洢��ʽ: �ȴ��±�, Ȼ����Ӧֵ
		int[] stack = new int[10001];
		int[] result = new int[nums.length];
		Arrays.fill(result, -1);
		int stack_idx = 0;
		// ��Ϊ��ѭ������, ��˱�������
		for (int i = 0; i < nums.length; i++) {
			while (stack_idx != 0 && stack[stack_idx - 1] < nums[i]) {
				// ��ջ����
				stack_idx -= 2;
				int idx = stack[stack_idx];
				result[idx] = i;
			}
			// ���ȥ����
			stack[stack_idx++] = i;
			stack[stack_idx++] = nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			while (stack_idx != 0 && stack[stack_idx - 1] < nums[i]) {
				// ��ջ����
				stack_idx -= 2;
				int idx = stack[stack_idx];

				if (result[idx] == -1)
					result[idx] = i;
			}
			// ���ȥ����
			stack[stack_idx++] = i;
			stack[stack_idx++] = nums[i];
		}
		// ȡ������һ��/�������и�ֵΪ-1
		for (int i = 0; i < result.length; i++) {
			if (result[i] == -1) continue;

			result[i] = nums[result[i]];
		}
		return result;
	}
}