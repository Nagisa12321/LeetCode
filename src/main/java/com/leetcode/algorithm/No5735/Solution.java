package com.leetcode.algorithm.No5735;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/18 10:47
 */
public class Solution {
	public int maxIceCream(int[] costs, int coins) {
		Arrays.sort(costs);
		int sum = 0, result = 0;
		for (int cost : costs) {
			sum += cost;
			if (sum > coins) return result;

			result++;
		}

		return result;
	}
}