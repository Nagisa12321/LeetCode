package com.leetcode.offer.No56.No2;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/29 10:44
 */
public class Solution2 {
	public int singleNumber(int[] nums) {
		// 考虑数字的二进制形式，对于出现三次的数字，各 二进制位 出现的次数都是 33 的倍数。
		// 因此，统计所有数字的各二进制位中 11 的出现次数，并对 33 求余，结果则为只出现一次的数字。
		int[] times = new int[32];

		for (int num : nums) {
			for (int i = 0; i < 32; i++) {
				times[31 - i] += (num >> i) & 1;
			}
		}

		for (int i = 0; i < 32; i++)
			times[i] %= 3;

		int result = 0;
		for (int i = 0; i < 32; i++) {
			result <<= 1;
			result += times[i];
		}

		return result;
	}
}
