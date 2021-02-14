package com.leetcode.binarytree.No3.No2;

import com.leetcode.struct.TreeNode;

import java.util.Stack;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/27 9:25
 */
public class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        var roots = new Stack<TreeNode>();
        int pre = 0, in = 0;
        TreeNode node = new TreeNode(preorder[0]);
        roots.push(node);
        TreeNode res = node;

        while (pre != preorder.length - 1) {
            if (preorder[pre] == inorder[in]) {
                while (!roots.isEmpty() && roots.peek().val == inorder[in]) {
                    node = roots.pop();
                    in++;
                }

                node.right = new TreeNode(preorder[++pre]);
                node = node.right;
                roots.push(node);
            } else {
                node.left = new TreeNode(preorder[++pre]);
                node = node.left;
                roots.push(node);
            }
        }

        return res;
    }
}