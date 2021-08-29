package com.leetcode.hashmap.No4.No2;

import com.leetcode.struct.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/6 11:21
 */
public class Solution2 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, TreeNode> map = new HashMap<>();
        inorder(root, map, new HashSet<>(), new HashMap<>(), new HashMap<>());
        return new LinkedList<>(map.values());
    }

    public String preorder(TreeNode root, HashMap<TreeNode, String> map) {
        if (root == null) return "$";
        String current = String.valueOf(root.val);
        map.put(root, current);

        String left;
        if (map.containsKey(root.left)) left = map.get(root.left);
        else left = preorder(root.left, map);

        String right;
        if (map.containsKey(root.right)) right = map.get(root.right);
        else right = preorder(root.right, map);

        return current + left + right;
    }

    public String inorder(TreeNode root, HashMap<TreeNode, String> map) {
        if (root == null) return "$";
        String current = String.valueOf(root.val);
        map.put(root, current);

        String left;
        if (map.containsKey(root.left)) left = map.get(root.left);
        else left = inorder(root.left, map);

        String right;
        if (map.containsKey(root.right)) right = map.get(root.right);
        else right = inorder(root.right, map);

        return left + current + right;
    }

    public void inorder(TreeNode root,
                         HashMap<String, TreeNode> map,
                         HashSet<String> set,
                         HashMap<TreeNode, String> inorder,
                         HashMap<TreeNode, String> preorder) {
        if (root == null) return;

        inorder(root.left, map, set, inorder, preorder);

        String traverseStr = preorder(root, preorder) + inorder(root, inorder);
        if (!set.add(traverseStr))
            map.put(traverseStr, root);

        inorder(root.right, map, set, inorder, preorder);
    }
}