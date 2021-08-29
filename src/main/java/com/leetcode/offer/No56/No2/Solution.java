package com.leetcode.offer.No56.No2;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/29 10:34
 */
public class Solution {
	public int singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for (var entry : map.entrySet()) {
			if (entry.getValue() == 1) return entry.getKey();
		}

		return 0;
	}
}