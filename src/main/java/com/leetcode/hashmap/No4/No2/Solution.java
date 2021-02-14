package com.leetcode.hashmap.No4.No2;

import com.leetcode.struct.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/6 10:55
 */
// Œﬁ”≈ªØ 1448ms
public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, TreeNode> map = new HashMap<>();
        inorder(root, map, new HashSet<>());
        return new LinkedList<>(map.values());
    }

    private String preorder(TreeNode root, int tmp) {
        if (root == null) return "";
        return String.valueOf(root.val) + tmp + preorder(root.left, tmp + 1) + preorder(root.right, tmp + 2);
    }

    private String inorder(TreeNode root, int tmp) {
        if (root == null) return "";
        return inorder(root.left, tmp + 1) + root.val + tmp + inorder(root.right, tmp + 2);
    }

    private void inorder(TreeNode root, HashMap<String, TreeNode> map, HashSet<String> set) {
        if (root == null) return;

        inorder(root.left, map, set);

        String traverseStr = preorder(root, 0) + inorder(root, 0);
        if (!set.add(traverseStr))
            map.put(traverseStr, root);

        inorder(root.right, map, set);
    }
}