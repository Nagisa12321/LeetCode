package com.leetcode.intermediate.No3.No3;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/11 15:51
 */
public class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                int[] leftInorder = new int[i];
                System.arraycopy(inorder, 0, leftInorder, 0, i);
                int[] rightInorder = new int[inorder.length - i - 1];
                System.arraycopy(inorder, i + 1, rightInorder, 0, inorder.length - i - 1);
                int[] leftPreorder = new int[i];
                System.arraycopy(preorder, 1, leftPreorder, 0, i);
                int[] rightPreorder = new int[inorder.length - i - 1];
                System.arraycopy(preorder, 1 + i, rightPreorder, 0, inorder.length - i - 1);
                root.left = buildTree(leftPreorder, leftInorder);
                root.right = buildTree(rightPreorder, rightInorder);
            }
        }
        return root;
    }
}