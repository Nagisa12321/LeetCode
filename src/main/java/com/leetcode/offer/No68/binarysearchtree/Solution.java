package com.leetcode.offer.No68.binarysearchtree;

import com.leetcode.struct.TreeNode;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/14 10:30
 */
public class Solution {
    // 同时find p 和 find q, 如果出现不同则上个节点为公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != p && node != q) {
            if (p.val < node.val) {
                if (q.val > node.val) return node;
                else node = node.left;
            } else {
                if (q.val < node.val) return node;
                else node = node.right;
            }
        }
        return node;
    }
}