package com.leetcode.algorithm.No648;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SolutionTest {

	@Test
	public void test1() {
		Solution solution = new Solution();

		ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "aa", "aaa", "aaaa"));
		System.out.println(solution.replaceWords(list, "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
	}
}