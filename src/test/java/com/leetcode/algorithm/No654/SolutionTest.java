package com.leetcode.algorithm.No654;

import com.leetcode.struct.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
	@Test
	public void test1() {
		int[] nums = {3, 2, 1, 6, 0, 5};
		Solution solution = new Solution();
		TreeNode treeNode = solution.constructMaximumBinaryTree(nums);
	}
}