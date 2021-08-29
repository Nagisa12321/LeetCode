package com.leetcode.algorithm.No1583;

public class SolutionTest {
	public static void main(String[] args) {
		int[][] p = {{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}};
		int[][] pair = {{0, 1}, {2, 3}};
		Solution solution = new Solution();
		System.out.println(solution.unhappyFriends(4, p, pair));
	}
}