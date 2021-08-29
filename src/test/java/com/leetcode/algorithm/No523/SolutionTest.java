package com.leetcode.algorithm.No523;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		Solution solution = new Solution();
		int[] nums = {0};
		boolean b = solution.checkSubarraySum(nums, 1);
		System.out.println(b);
	}
}