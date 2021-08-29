package com.leetcode.algorithm.No932;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		Solution solution = new Solution();
		int[] ints = solution.beautifulArray(5);
		System.out.println(Arrays.toString(ints));
	}
}