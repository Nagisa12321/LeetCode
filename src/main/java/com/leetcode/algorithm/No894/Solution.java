package com.leetcode.algorithm.No894;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/4/8 16:09
 */
public class Solution {
	public List<TreeNode> allPossibleFBT(int n) {
		List<TreeNode> list = new ArrayList<>();
		if (n % 2 == 0) return list;
		else if (n == 1) {
			list.add(new TreeNode());
			return list;
		}
		n--;
		for (int i = 1; i < n; i += 2) {
			List<TreeNode> left = allPossibleFBT(i);
			List<TreeNode> right = allPossibleFBT(n - i);

			for (TreeNode treeNode : left) {
				for (TreeNode value : right) {
					TreeNode node = new TreeNode();
					node.left = treeNode;
					node.right = value;
					list.add(node);
				}
			}
		}
		return list;
	}
}