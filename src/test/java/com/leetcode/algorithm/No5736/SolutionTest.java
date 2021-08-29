package com.leetcode.algorithm.No5736;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
	@Test
	public void test1() {
		Solution solution = new Solution();
		int[][] tasks = {{100, 100}, {1000000000, 1000000000}};
		int[] order = solution.getOrder(tasks);
		System.out.println(Arrays.toString(order));
	}
}