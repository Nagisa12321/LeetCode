package com.leetcode.algorithm.No220;

import org.junit.Test;

public class SolutionTest {
	@Test
	public void test1() {
		int[] arr = {1, 5, 9, 1, 5, 9};

		Solution solution = new Solution();
		System.out.println(solution.containsNearbyAlmostDuplicate(arr, 2, 3));
	}
}