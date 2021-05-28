package com.leetcode.week.No236.No3;

import org.junit.Test;

public class SolutionTest {
	@Test
	public void test1() {
		int[] obstacles = {0, 1, 2, 3, 0};
		int i = new Solution().minSideJumps(obstacles);
		System.out.println(i);
	}
}