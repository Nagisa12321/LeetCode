package com.leetcode.algorithm.No137;

import org.junit.Test;

public class Solution2Test {
	@Test
	public void test1() {
		int[] nums = {0, 1, 0, 1, 0, 1, 99};

		Solution2 solution2 = new Solution2();
		System.out.println(solution2.singleNumber(nums));
	}
}