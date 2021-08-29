package com.leetcode.algorithm.No773;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		Solution2 solution = new Solution2();

		int[][] arr = {{4,3,2},{0,1,5}};
		System.out.println(solution.slidingPuzzle(arr));
	}
}