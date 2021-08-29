package com.leetcode.algorithm.No363;

import org.junit.Test;

public class Solution2Test {
	@Test
	public void test1() {
		Solution2 solution2 = new Solution2();

		int[][] matrix = {
				{5, -4, -3, 4},
				{-3, -4, 4, 5},
				{5, 1, 5, -4}
		};

		System.out.println(solution2.maxSumSubmatrix(matrix, 8));
	}
}