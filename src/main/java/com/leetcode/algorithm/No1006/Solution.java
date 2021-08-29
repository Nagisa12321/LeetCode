package com.leetcode.algorithm.No1006;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/1 15:13
 */
public
class Solution {
	public int clumsy(int N) {
		if (N <= 4) return calculateSmall(N);

		int pairs = N / 4;
		int result = N * (N - 1) / (N - 2) + (N - 3);
		for (int i = 1; i < pairs; i++) {
			result -= calculate(N - i * 4);
		}
		result -= calculateSmall(N % 4);

		return result;
	}

	private int calculate(int N) {
		return N * (N - 1) / (N - 2) - (N - 3);
	}

	private int calculateSmall(int N) {
		return N *
				((N - 1) > 0 ? N - 1 : 1) /
				((N - 2) > 0 ? N - 2 : 1) +
				(Math.max((N - 3), 0));
	}
}