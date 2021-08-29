package com.leetcode.algorithm.No167;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/12 14:20
 */
public class Solution4 {
	public int[] twoSum(int[] numbers, int target) {
		int left = 0, right = numbers.length - 1;

		while (left < right) {
			if (numbers[left] + numbers[right] == target) return new int[]{left + 1, right + 1};
			else if (numbers[left] + numbers[right] < target) left++;
			else right--;
		}

		return new int[2];
	}
}