package com.leetcode.algorithm.No671;

import com.leetcode.struct.TreeNode;

import static org.junit.Assert.*;

public class SolutionTest {
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(2, new TreeNode(2), new TreeNode(2));
		System.out.println(solution.findSecondMinimumValue(root));
	}

}