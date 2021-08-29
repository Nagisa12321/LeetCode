package com.leetcode.algorithm.No137;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/30 16:15
 */
public class Solution2 {
	public int singleNumber(int[] nums) {
		int[] times = new int[32]; // 代表1出现的次数
		int negative = 0;

		int len = nums.length;
		for (int i = 0; i < len; i++) {
			int num = nums[i];
			if (num < 0) negative++;

			int idx = 31;
			while (num != 0) {
				times[idx--] += num % 2;
				num /= 2;
			}
		}

		int res = 0;
		for (int i = 0; i < 32; i++) {
			if (times[i] % 3 == 0) res = res * 2;
			else res = res * 2 + 1;
		}

		return negative % 3 == 0  ? res : -res;
	}
}