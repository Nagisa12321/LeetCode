package com.leetcode.algorithm.No1967;

import static org.junit.Assert.*;

public class SolutionTest {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isChild("a", "abc".toCharArray()));
		System.out.println(solution.isChild("ac", "abc".toCharArray()));
		System.out.println(solution.isChild("abcd", "abc".toCharArray()));
	}
}