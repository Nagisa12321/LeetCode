package com.leetcode.algorithm.No90;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		Solution solution = new Solution();


		int[] nums = {4, 1, 4};
		System.out.println(solution.subsetsWithDup(nums));
	}
}