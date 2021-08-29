package com.leetcode.intermediate.No7.No1;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/30 13:00
 */
public class Codec1 {

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
            var tmpList = new ArrayList<TreeNode>();
            for (int i = 0; i < size; i++) {
                var tmpNode = queue.poll();
                if (tmpNode == null) {

                    list.add("null");
                } else {
                    queue.offer(tmpNode.left);
                    queue.offer(tmpNode.right);

                    list.add(String.valueOf(tmpNode.val));
                }
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
        int idx = 1;
        while (idx < nodeStrs.length) {

            var node = queue.poll();
            assert node != null;
            node.left = get(nodeStrs, idx);
            node.right = get(nodeStrs, idx + 1);

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);

            idx += 2;
        }

        return root;
    }

    private TreeNode get(String[] nodeStrs, int idx) {
        if (nodeStrs[idx].equals("null")) return null;
        return new TreeNode(Integer.parseInt(nodeStrs[idx]));
    }
}
