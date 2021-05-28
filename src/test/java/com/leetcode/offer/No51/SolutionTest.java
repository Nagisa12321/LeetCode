package com.leetcode.offer.No51;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		Solution solution = new Solution();
		// int[] nums = {1, 4, 2, 8, 5, 7};
		 int[] nums = {3, 77, 40, 17, 68, 0, 86, 77, 40, 39, 73, 12, 62, 21, 43, 89, 58, 76, 32, 27};

		System.out.println(Arrays.toString(nums));
		System.out.println(solution.reversePairs(nums));
		System.out.println(Arrays.toString(nums));
	}

}