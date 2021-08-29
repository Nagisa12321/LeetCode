package com.leetcode.offer.No56.No1;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/28 17:33
 */
public class Solution {
	public int[] singleNumbers(int[] nums) {
		int x = 0;
		for (int num : nums) x ^= num;

		int idx = 0;
		while ((x & 1) == 0) {
			idx++;
			x >>>= 1;
		}

		int numA = 0;
		int numB = 0;
		for (int num : nums) {
			if (((num >> idx) & 1) == 0) numA ^= num;
			else numB ^= num;
		}

		return new int[]{numA, numB};
	}
}