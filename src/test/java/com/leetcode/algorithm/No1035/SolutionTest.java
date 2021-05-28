package com.leetcode.algorithm.No1035;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		Solution solution = new Solution();
		int[] nums1 = {1, 4, 2};
		int[] nums2 = {1, 2, 4};
		System.out.println(solution.maxUncrossedLines(nums1, nums2));
	}
}