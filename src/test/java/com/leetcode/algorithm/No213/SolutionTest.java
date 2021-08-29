package com.leetcode.algorithm.No213;

import org.junit.Test;

public class SolutionTest {


	@Test
	public void test1() {
		int[] nums = {2, 2, 4, 3, 2, 5};

		int rob = new Solution().rob(nums);
		System.out.println(rob);
	}
}