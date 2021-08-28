package com.leetcode.algorithm.No40;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		/*
		[10,1,2,7,6,1,5]
		8
		 */
		int[] nums = {2, 5, 2, 1, 2};
		Solution solution = new Solution();
		System.out.println(solution.combinationSum2(nums, 5));
	}
}