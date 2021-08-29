package com.leetcode.intermediate.No3.No4;

import java.util.LinkedList;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/15 13:43
 */
public class Solution2 {
    public Node connect(Node root) {
        if (root == null) return null;

        var queue = new LinkedList<Node>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Node tmp = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (tmp == null) tmp = node;
                else {
                    tmp.next = node;
                    tmp = tmp.next;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }
}