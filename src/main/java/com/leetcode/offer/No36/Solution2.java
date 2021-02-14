package com.leetcode.offer.No36;

import com.leetcode.struct.Node;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/13 9:57
 */
public class Solution2 {
    private Node pre = null, head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        inorder(root);

        head.left = pre;
        pre.right = head;

        return head;
    }

    public void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);

        if (pre == null) head = node;
        else {
            pre.right = node;
            node.left = pre;
        }

        pre = node;

        inorder(node.right);
    }
}
