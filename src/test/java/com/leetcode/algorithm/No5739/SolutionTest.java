package com.leetcode.algorithm.No5739;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		Solution solution = new Solution();
		int[] nums = {1, 4, 8, 13};
		System.out.println(solution.maxFrequency(nums, 5));
	}
}