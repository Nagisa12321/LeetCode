package com.leetcode.algorithm.No554;

import java.util.*;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/5/2 15:26
 */
public class Solution2 {
	public int leastBricks(List<List<Integer>> wall) {
		int size = wall.size();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (List<Integer> oneOfWalls : wall) {
			int sum = 0;
			for (int i = 0; i < oneOfWalls.size(); i++) {
				sum += oneOfWalls.get(i);
				if (i != oneOfWalls.size() - 1) {
					map.put(sum, map.getOrDefault(sum, 0) + 1);
				}
			}
		}
		int min = size;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			min = Math.min(min, size - entry.getValue());
		}
		return min;

	}
}