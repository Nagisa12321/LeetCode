package com.leetcode.binarysearchtree.No2.No3;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/7 14:13
 */
public class Solution {
	public TreeNode deleteNode(TreeNode root, int key) {
		// 记录该删除的节点和它的parent
		TreeNode removeNode;
		TreeNode removeNodeParent = null;

		removeNode = root;
		while (removeNode != null) {
			if (removeNode.val == key) break;
			else if (removeNode.val < key) {
				removeNodeParent = removeNode;
				removeNode = removeNode.right;
			} else {
				removeNodeParent = removeNode;
				removeNode = removeNode.left;
			}
		}
		// 1. 找不到该节点
		if (removeNode == null) return root;

			// 2. 没有左右子树
		else if (removeNode.left == null && removeNode.right == null) {
			if (removeNodeParent == null) return null;
			else if (removeNodeParent.right == removeNode) {
				removeNodeParent.right = null;
				return root;
			} else {
				removeNodeParent.left = null;
				return root;
			}
		}

		// 3. 只有左子树或右子树
		else if (removeNode.left == null || removeNode.right == null) {
			if (removeNodeParent == null) {
				if (removeNode.left != null) return removeNode.left;
				else return removeNode.right;
			} else if (removeNodeParent.right == removeNode)
				removeNodeParent.right = removeNode.left == null ? removeNode.right : removeNode.left;
			else removeNodeParent.left = removeNode.left == null ? removeNode.right : removeNode.left;
		}

		// 4. 既有左子树又有右子树
		else {
			TreeNode succsor = removeNode.right;
			TreeNode succsorParent = removeNode;

			while (succsor.left != null) {
				succsorParent = succsor;
				succsor = succsor.left;
			}

			if (succsorParent == removeNode) {
				removeNode.right.left = removeNode.left;
				if (removeNodeParent == null) return removeNode.right;
				else if (removeNodeParent.left == removeNode) removeNodeParent.left = removeNode.right;
				else removeNodeParent.right = removeNode.right;
			} else {
				removeNode.val = succsor.val;
				succsorParent.left = succsor.right;
			}
			return root;
		}

		return root;
	}
}