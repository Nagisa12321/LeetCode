package com.leetcode.algorithm.No1829;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.getMaximumXor(new int[]{0,1,2,2,5,7}, 3)));
	}

}