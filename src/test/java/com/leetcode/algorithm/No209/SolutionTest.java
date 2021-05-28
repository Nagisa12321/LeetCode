package com.leetcode.algorithm.No209;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

	private final Solution solution = new Solution();

	@Test
	public void test1() {
		int[] test = {2, 3, 1, 2, 4, 3};
		System.out.println(solution.minSubArrayLen(7, test));
	}


}