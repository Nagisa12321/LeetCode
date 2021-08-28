package com.leetcode.algorithm.No743;

import static org.junit.Assert.*;

public class SolutionTest {
	public static void main(String[] args) {
		int[][] ways = {
				{2, 1, 1},
				{2, 3, 1},
				{3, 4, 1}
		};

		Solution solution = new Solution();
		System.out.println(solution.networkDelayTime(ways, 4, 2));
	}
}