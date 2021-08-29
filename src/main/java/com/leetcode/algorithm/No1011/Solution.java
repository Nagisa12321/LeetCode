package com.leetcode.algorithm.No1011;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/26 9:58
 */
public class Solution {
	public int shipWithinDays(int[] weights, int D) {
		int sum = 0;
		for (int i = 0; i < weights.length; i++) {
			sum += weights[i];
		}
		// lo, hi 都是运输能力
		int lo = 0, hi = sum;

		for (int i = 0; i < weights.length; i++) {
			lo = Math.max(weights[i], lo);
		}
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;

			int days = 1;
			int tmp = 0;
			for (int i = 0; i < weights.length; i++) {
				tmp += weights[i];
				if (tmp > mid) {
					days++;
					tmp = weights[i];
				}
			}

			if (days > D) lo = mid + 1;
			else hi = mid;
		}

		return lo;
	}
}