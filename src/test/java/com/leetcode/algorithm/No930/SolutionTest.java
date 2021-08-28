package com.leetcode.algorithm.No930;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		int[] arr = {1, 0, 1, 0, 1};

		Solution solution = new Solution();
		System.out.println(solution.numSubarraysWithSum(arr, 2));
	}
}