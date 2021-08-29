package com.leetcode.advanced.treeorfigure.No4;

import com.leetcode.struct.TreeNode;
import org.junit.Test;

public class SolutionTest {
	private final Solution solution = new Solution();


	@Test
	public void maxPathSum() {
		TreeNode node = new TreeNode(10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

		System.out.println(solution.maxPathSum(node));
	}


}