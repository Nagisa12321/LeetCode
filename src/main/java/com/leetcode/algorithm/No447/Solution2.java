package com.leetcode.algorithm.No447;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/16 15:08
 */
public class Solution2 {
	public int numberOfBoomerangs(int[][] points) {
		int result = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int[] point : points) {
			map.clear();
			for (int[] ints : points) {
				int x_dic = point[0] - ints[0];
				int y_dic = point[1] - ints[1];
				int dic = x_dic * x_dic + y_dic * y_dic;
				map.put(dic, map.getOrDefault(dic, 0) + 1);
			}

			for (int val : map.values()) {
				result += (val - 1) * val;
			}
		}
		return result;
	}
}