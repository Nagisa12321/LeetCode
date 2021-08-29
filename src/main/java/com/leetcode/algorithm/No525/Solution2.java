package com.leetcode.algorithm.No525;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/6/3 9:39
 */
public class Solution2 {
	// Ç°×ººÍ + hashmap
	public int findMaxLength(int[] nums) {
		int[] sum = new int[nums.length];
		sum[0] = nums[0] == 0 ? -1 : 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == 0) sum[i] = sum[i- 1] - 1;
			else sum[i] = sum[i - 1] + 1;
		}
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(sum[i])) {
				max = Math.max(i - map.get(sum[i]), max);
			} else map.put(sum[i], i);
		}
		return max;
	}
}