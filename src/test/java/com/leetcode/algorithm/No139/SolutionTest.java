package com.leetcode.algorithm.No139;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		Solution solution = new Solution();
		System.out.println(solution.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
	}
}