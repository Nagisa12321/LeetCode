package com.leetcode.algorithm.No1449;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		Solution solution = new Solution();
		int[] cost = {4,3,2,5,6,7,2,5,5};
		System.out.println(solution.largestNumber(cost, 9));
	}

}