package com.leetcode.lcp.No10;

import com.leetcode.struct.TreeNode;

import static org.junit.Assert.*;

public class SolutionTest {
	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode node = new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(5), new TreeNode(6)));
		System.out.println(solution.minimalExecTime(node));
	}
}