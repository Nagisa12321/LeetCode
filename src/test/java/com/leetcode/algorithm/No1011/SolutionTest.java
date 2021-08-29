package com.leetcode.algorithm.No1011;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Solution solution = new Solution();

		int i = solution.shipWithinDays(nums, 5);
		System.out.println(i);
	}
}