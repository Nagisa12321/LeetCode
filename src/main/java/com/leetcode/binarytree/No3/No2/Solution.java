package com.leetcode.binarytree.No3.No2;

import com.leetcode.struct.TreeNode;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/18 19:16
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder,
                0, preorder.length - 1,
                0, map);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder,
                              int preorder_l, int preorder_r,
                              int inorder_l, HashMap<Integer, Integer> map) {
        if (preorder_l > preorder_r) return null;

        int root = preorder[preorder_l];
        TreeNode node = new TreeNode(root);
        int i = map.get(root);

        int len_left = i - inorder_l;
        node.left = buildTree(preorder, inorder,
                preorder_l + 1, preorder_l + len_left,
                inorder_l, map);
        node.right = buildTree(preorder, inorder,
                preorder_l + len_left + 1, preorder_r,
                i + 1, map);
        return node;
    }
}