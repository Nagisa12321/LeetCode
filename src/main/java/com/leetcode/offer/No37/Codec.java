package com.leetcode.offer.No37;

import com.leetcode.struct.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder builder = new StringBuilder();
        dfs(root, builder);
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] strs = data.split(" ");
        TreeNode head = new TreeNode(Integer.parseInt(strs[0]));
        TreeNode node = head;
        Stack<TreeNode> stack = new Stack<>();

        boolean left = true;
        stack.push(node);
        for (int i = 1; i < strs.length; i++) {
            if (left) {
                if (strs[i].equals("null")) {
                    left = false;
                } else {
                    TreeNode tmp = new TreeNode(Integer.parseInt(strs[i]));
                    node.left = tmp;
                    stack.push(tmp);
                    node = tmp;
                }
            } else {
                if (strs[i].equals("null")) {
                    stack.pop();
                    if (!stack.isEmpty()) node = stack.peek();
                } else {
                    stack.pop();
                    left = true;
                    TreeNode tmp = new TreeNode(Integer.parseInt(strs[i]));
                    node.right = tmp;
                    stack.push(tmp);
                    node = tmp;
                }
            }
        }
        return head;
    }

    private void dfs(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("null ");
            return;
        }
        builder.append(node.val).append(" ");
        dfs(node.left, builder);
        dfs(node.right, builder);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
