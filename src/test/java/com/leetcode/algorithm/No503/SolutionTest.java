package com.leetcode.algorithm.No503;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
	@Test
	public void test1() {
		Solution solution = new Solution();

		int[] arr = {1, 4, 2, 8, 5, 7};

		System.out.println(Arrays.toString(solution.nextGreaterElements(arr)));
	}
}