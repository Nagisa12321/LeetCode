package com.leetcode.algorithm.No207;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution1Test {
	@Test
	public void test1() {
		Solution1 solution1 = new Solution1();
		int[][] arr = {{2,0},{1,0},{3,1},{3,2},{1,3}};
		System.out.println(solution1.canFinish(4, arr));
	}
}