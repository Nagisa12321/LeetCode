package com.leetcode.algorithm.No167;

import org.junit.Test;

import java.util.Arrays;

public class Solution2Test {


	@Test
	public void test1() {
		Solution2 solution2 = new Solution2();


		int[] test = {-1000, -1, 0, 1};
		int[] ints = solution2.twoSum(test, 2);
		System.out.println(Arrays.toString(ints));
	}

}