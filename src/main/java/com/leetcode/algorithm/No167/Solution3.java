package com.leetcode.algorithm.No167;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/12 14:10
 */
public class Solution3 {
	public int[] twoSum(int[] numbers, int target) {
		for (int i = 0; i < numbers.length; i++) {
			int num2 = target - numbers[i];
			int lo = i, hi = numbers.length - 1;

			while (lo <= hi) {
				int mid = lo + (hi - lo) / 2;
				if (numbers[mid] == num2 && mid != i) return new int[]{i + 1, mid + 1};
				else if (numbers[mid] > num2) hi = mid - 1;
				else lo = mid + 1;
			}
		}

		return new int[2];
	}
}