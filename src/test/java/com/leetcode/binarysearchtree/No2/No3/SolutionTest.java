package com.leetcode.binarysearchtree.No2.No3;

import com.leetcode.struct.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
	private final Solution solution = new Solution();

	@Test
	public void deleteNode() {
		TreeNode node = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));

		solution.deleteNode(node, 3);
	}
}