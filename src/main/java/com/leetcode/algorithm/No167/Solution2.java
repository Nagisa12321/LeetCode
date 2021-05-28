package com.leetcode.algorithm.No167;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/12 13:56
 */
public class Solution2 {
	public int[] twoSum(int[] numbers, int target) {
		int[] map = new int[2001]; // [-1000, 1000]

		for (int i = 0; i < numbers.length; i++) {
			// -1000 --> 0
			map[numbers[i] + 1000] = i + 1;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (target - numbers[i] >= -1000 && target - numbers[i] <= 1000 && map[target - numbers[i] + 1000] > 0) {
				if (map[target - numbers[i] + 1000] != i + 1)
					return new int[]{i + 1, map[target - numbers[i] + 1000]};
			}
		}


		return new int[2];
	}
}
