package com.leetcode.algorithm.No498;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
	private final Solution solution = new Solution();

	@Test
	public void findDiagonalOrder() {

		int[][] test = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};

		System.out.println(Arrays.toString(solution.findDiagonalOrder(test)));
	}
}