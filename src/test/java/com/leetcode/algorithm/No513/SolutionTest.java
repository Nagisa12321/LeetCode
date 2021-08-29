package com.leetcode.algorithm.No513;

import com.leetcode.struct.TreeNode;
import org.junit.Test;

public class SolutionTest {
	@Test
	public void test1() {
		TreeNode node =
				new TreeNode(1,
						new TreeNode(2,
								new TreeNode(4),
								null),
						new TreeNode(3,
								new TreeNode(5,
										new TreeNode(7),
										null),
								new TreeNode(6)));
		Solution solution = new Solution();
		System.out.println(solution.findBottomLeftValue(node));
	}
}