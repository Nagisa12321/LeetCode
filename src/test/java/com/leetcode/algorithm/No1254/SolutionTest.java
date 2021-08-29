package com.leetcode.algorithm.No1254;

import org.junit.Test;

public class SolutionTest {
	private final Solution solution = new Solution();

	@Test
	public void closedIsland() {
		int[][] test = {
				{0, 0, 1, 0, 0},
				{0, 1, 0, 1, 0},
				{0, 0, 1, 0, 0}
		};

		System.out.println(solution.closedIsland(test));
	}
}