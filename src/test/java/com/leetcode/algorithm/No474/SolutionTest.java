package com.leetcode.algorithm.No474;

import org.junit.Test;

public class SolutionTest {
	@Test
	public void test1() {
		Solution solution = new Solution();
		String[] strs = {"10", "0001", "111001", "1", "0"};
		System.out.println(solution.findMaxForm(strs, 5, 3));
	}
}