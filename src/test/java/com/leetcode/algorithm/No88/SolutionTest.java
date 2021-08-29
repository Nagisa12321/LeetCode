package com.leetcode.algorithm.No88;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums1 = {1, 2, 3, 0, 0, 0};
		solution.merge(nums1, 3, new int[]{2, 5, 6}, 4);
		System.out.println(Arrays.toString(nums1));
	}

}