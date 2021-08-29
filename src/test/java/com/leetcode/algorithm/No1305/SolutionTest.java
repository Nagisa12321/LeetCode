package com.leetcode.algorithm.No1305;

import com.leetcode.struct.TreeNode;
import org.junit.Test;

import java.util.List;
import java.util.Stack;

public class SolutionTest {

	@Test
	public void test1() {
		TreeNode node1 = new TreeNode(2, new TreeNode(1), new TreeNode(4));
		TreeNode node2 = new TreeNode(1, new TreeNode(0), new TreeNode(3));

		Solution solution = new Solution();
		List<Integer> allElements = solution.getAllElements(node1, node2);

		System.out.println(allElements);

		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || node1 != null) {
			while (node1 != null) {
				stack.push(node1);
				node1 = node1.left;
			}
			node1 = stack.pop();
			System.out.println(node1.val);
			node1 = node1.right;
		}

	}

	@Test
	public void test2() {
		TreeNode node1 = new TreeNode(1, null, new TreeNode(8));
		TreeNode node2 = new TreeNode(8, new TreeNode(1), null);

		Solution solution = new Solution();
		List<Integer> allElements = solution.getAllElements(node1, node2);

		System.out.println(allElements);
	}


}