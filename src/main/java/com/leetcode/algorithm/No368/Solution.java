package com.leetcode.algorithm.No368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/23 9:12
 */
public class Solution {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length;
		// ��hashMap���洢 idx -> List<Integer> �Ľṹ
		// ÿ�ζ�����ǰ��, ����㷨ΪO(n^2)
		int[][] dp = new int[len][2]; // dp[i] ��ʾ ��ǰ��������Ӽ�����
		int max = 0;
		int max_idx = 0;
		for (int i = 0; i < len; i++) {
			dp[i][0] = 1;
			dp[i][1] = i;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0 && dp[i][0] <= dp[j][0]) {
					dp[i][0] = dp[j][0] + 1;
					dp[i][1] = j; // ��¼��һ��Ԫ��ֵ
				}
			}

			if (dp[i][0] > max) {
				max = dp[i][0];
				max_idx = i;
			}
		}

		List<Integer> result = new ArrayList<>();
		while (dp[max_idx][1] != max_idx) {
			result.add(nums[max_idx]);
			max_idx = dp[max_idx][1];
		}
		result.add(nums[max_idx]);

		return result;
	}
}