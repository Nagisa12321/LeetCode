package com.leetcode.intermediate.No7.No1;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;


/*
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/30 12:01
 */

// 超出时间限制
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        var list = new ArrayList<String>();
        var queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 有真实子节点而非空才会继续加入队列中
            // 不然会导致死循环
            boolean hasSon = false;
            var tmpList = new ArrayList<TreeNode>();
            for (int i = 0; i < size; i++) {
                var tmpNode = queue.poll();
                if (tmpNode == null) {
                    tmpList.add(null);
                    tmpList.add(null);

                    list.add("null");
                } else {
                    if (tmpNode.left != null || tmpNode.right != null)
                        hasSon = true;
                    tmpList.add(tmpNode.left);
                    tmpList.add(tmpNode.right);

                    list.add(String.valueOf(tmpNode.val));
                }
            }

            if (hasSon) {
                queue.addAll(tmpList);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (var node : list) {
            builder.append(node).append(" ");
        }

        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] nodeStrs = data.split(" ");
        var queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(nodeStrs[0]));
        queue.offer(root);
        for (int i = 0; i < nodeStrs.length / 2; i++) {
            if (get(nodeStrs, i) != null) {
                var node = queue.poll();
                assert node != null;
                node.left = get(nodeStrs, (i + 1) * 2 - 1);
                node.right = get(nodeStrs, (i + 1) * 2);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return root;
    }

    private TreeNode get(String[] nodeStrs, int idx) {
        if (nodeStrs[idx].equals("null")) return null;
        return new TreeNode(Integer.parseInt(nodeStrs[idx]));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));