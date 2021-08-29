package com.leetcode.algorithm.No167;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/12 13:55
 */
public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i], i + 1);
		}

		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				int idx = map.get(target - numbers[i]);
				if (i + 1 != map.get(target - numbers[i]))
					return new int[]{i + 1, idx};
			}
		}


		return new int[2];
	}
}