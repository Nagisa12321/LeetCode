package com.leetcode.algorithm.No485;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/11 20:40
 */
public class Solution {
	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int cur = 0;
		for (int num : nums) {
			if (num == 0) {
				max = Math.max(cur, max);
				cur = 0;
			} else {
				cur++;
			}
		}
		max = Math.max(cur, max);

		return max;
	}
}