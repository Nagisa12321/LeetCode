package com.leetcode.advanced.treeorfigure.No8;

import org.junit.Test;

public class SolutionTest {
	private final Solution solution = new Solution2();

	@Test
	public void longestIncreasingPath() {
		int[][] test = {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
		System.out.println(solution.longestIncreasingPath(test));
	}
}