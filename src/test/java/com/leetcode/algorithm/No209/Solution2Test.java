package com.leetcode.algorithm.No209;

import org.junit.Test;

public class Solution2Test {
	private final Solution2 solution = new Solution2();

	@Test
	public void test1() {
		int[] test = {2, 3, 1, 2, 4, 3};
		System.out.println(solution.minSubArrayLen(7, test));
	}

}