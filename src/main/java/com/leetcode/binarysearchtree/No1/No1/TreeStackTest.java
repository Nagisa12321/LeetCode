package com.leetcode.binarysearchtree.No1.No1;

import com.leetcode.struct.TreeNode;



import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/6 11:42
 */
public class TreeStackTest {
	public void printTree(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode tmp = root;

		while (!stack.isEmpty() || tmp != null) {
			while (tmp != null) {
				stack.push(tmp);
				tmp = tmp.left;
			}
			tmp = stack.pop();
			System.out.println(tmp.val);
			tmp = tmp.right;
		}
	}


	public static void main(String[] args) {
		TreeStackTest test = new TreeStackTest();
		TreeNode node = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
		test.printTree(node);
	}
}
