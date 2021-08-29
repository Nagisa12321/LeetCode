package com.leetcode.algorithm.No5837;

public class SolutionTest {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] arr = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
		System.out.println(solution.countPaths(7, arr));
	}
}