package com.leetcode.algorithm.No1143;

import org.junit.Test;

public class SolutionTest {
	@Test
	public void test1() {
		Solution solution = new Solution();

		String s1 = "oxcpqrsvwf";
		String s2 = "shmtulqrypy";

		System.out.println(solution.longestCommonSubsequence(s1, s2));
	}
}