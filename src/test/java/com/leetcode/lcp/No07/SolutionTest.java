package com.leetcode.lcp.No07;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		Solution solution = new Solution();
		int[][] arr = {{0,2}, {2,1}, {3,4}, {2,3}, {1,4}, {2,0}, {0,4}};
		// int[][] arr = {{0,2}, {0,1}, {1,2}, {2,1}, {2,0}, {1,0}};
		System.out.println(solution.numWays(3, arr, 1));
	}
}