package com.leetcode.algorithm.No5786;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		Solution solution = new Solution();
		int[] removeable = {5,3,0,6,4,9,10,7,2,8};
		System.out.println(solution.maximumRemovals("qobftgcueho", "obue", removeable));
	}

	@Test
	public void test2() {
		Solution solution = new Solution();
		System.out.println(solution.isSubStr(new boolean[100], "abcd", "abcc"));
	}
}