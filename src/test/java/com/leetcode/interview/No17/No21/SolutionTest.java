package com.leetcode.interview.No17.No21;

import org.junit.Test;

public class SolutionTest {
	@Test
	public void test1() {
		int[] test = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		Solution solution = new Solution();
		System.out.println(solution.trap(test));
	}
}