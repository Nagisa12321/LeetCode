package com.leetcode.algorithm.No97;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution2Test {
	@Test
	public void test1() {
		String s1 = "aa";
		String s2 = "ab";
		String s3 = "abaa";

		Solution2 solution2 = new Solution2();
		boolean interleave = solution2.isInterleave(s1, s2, s3);
		System.out.println(interleave);
	}
}