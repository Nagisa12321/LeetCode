package com.leetcode.queueorstack.summary.No5;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

	public final Solution solution = new Solution();

	@Test
	public void updateMatrix() {


		int[][] test = {
				{1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
				{0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
				{0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
				{1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
				{0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
				{0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
				{0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
				{1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
				{1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
				{1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
		System.out.println(Arrays.deepToString(solution.updateMatrix(test)));

	}
}