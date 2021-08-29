package com.leetcode.algorithm.No1382;

import com.leetcode.struct.TreeNode;
import org.junit.Test;

public class SolutionTest {
	@Test
	public void test1() {
		TreeNode node =
				new TreeNode(1,
						null,
						new TreeNode(2,
								null,
								new TreeNode(3,
										null,
										new TreeNode(4))));

		Solution solution = new Solution();
		TreeNode treeNode = solution.balanceBST(node);
	}
}