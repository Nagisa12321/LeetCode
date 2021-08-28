package com.leetcode.algorithm.No802;

public class Solution1Test {
	public static void main(String[] args) {
		Solution1 solution = new Solution1();
		int[][] g = {{0}, {2, 3, 4}, {3, 4}, {0, 4}, {}};
		System.out.println(solution.eventualSafeNodes(g));
	}
}