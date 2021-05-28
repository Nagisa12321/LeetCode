package com.leetcode.algorithm.No865;

import com.leetcode.struct.TreeNode;
import org.junit.Test;

public class SolutionTest {
	@Test
	public void test1() {

		TreeNode root =
				new TreeNode(3,
						new TreeNode(5,
								new TreeNode(6),
								new TreeNode(2,
										new TreeNode(7),
										new TreeNode(4))),
						new TreeNode(1,
								new TreeNode(0),
								new TreeNode(8)));

		Solution solution = new Solution();
		System.out.println(solution.subtreeWithAllDeepest(root));

	}
}