package com.leetcode.algorithm.No313;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		Solution solution = new Solution();
		int[] arr = {2, 7, 13, 19};

		System.out.println(solution.nthSuperUglyNumber(12, arr));
	}
}