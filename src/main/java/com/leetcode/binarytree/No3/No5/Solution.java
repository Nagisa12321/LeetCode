package com.leetcode.binarytree.No3.No5;

import com.leetcode.struct.TreeNode;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/3 10:19
 */
public class Solution {
    // 记录某个节点之下是否有P
    private final HashMap<TreeNode, Boolean> PMap = new HashMap<>();
    // 记录某个节点之下是否有Q
    private final HashMap<TreeNode, Boolean> QMap = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (havePQ(root, p, q) && !havePQ(root.left, p, q) && !havePQ(root.right, p, q)) return root;
        else {
            TreeNode treeNode = lowestCommonAncestor(root.left, p, q);
            return treeNode == null ? lowestCommonAncestor(root.right, p, q) : treeNode;
        }
    }

    public boolean haveP(TreeNode node, TreeNode p) {
        if (node == p) return true;
        else if (node == null) return false;

        boolean left;
        boolean right;

        if (PMap.containsKey(node.left)) left = PMap.get(node.left);
        else {
            left = haveP(node.left, p);
            PMap.put(node.left, left);
        }
        if (PMap.containsKey(node.right)) right = PMap.get(node.right);
        else {
            right = haveP(node.right, p);
            PMap.put(node.right, right);
        }
        return left || right;
    }

    public boolean haveQ(TreeNode node, TreeNode q) {
        if (node == q) return true;
        else if (node == null) return false;

        boolean left;
        boolean right;

        if (QMap.containsKey(node.left)) left = QMap.get(node.left);
        else {
            left = haveQ(node.left, q);
            QMap.put(node.left, left);
        }
        if (QMap.containsKey(node.right)) right = QMap.get(node.right);
        else {
            right = haveQ(node.right, q);
            QMap.put(node.right, right);
        }
        return left || right;
    }

    public boolean havePQ(TreeNode node, TreeNode p, TreeNode q) {
        return haveP(node, p) && haveQ(node, q);
    }
}