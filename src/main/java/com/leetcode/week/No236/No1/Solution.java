package com.leetcode.week.No236.No1;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/11 10:35
 */
public class Solution {
	public int arraySign(int[] nums) {
		boolean isBiggerThanZero = true;
		for (int num : nums) {
			if (num == 0) return 0;
			else if (num < 0) isBiggerThanZero = !isBiggerThanZero;
		}

		return isBiggerThanZero ? 1 : -1;
	}
}