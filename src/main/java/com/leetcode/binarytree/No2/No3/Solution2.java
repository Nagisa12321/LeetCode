package com.leetcode.binarytree.No2.No3;

import com.leetcode.struct.TreeNode;

import java.util.LinkedList;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/17 14:44
 */
public class Solution2 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        var queue_root = new LinkedList<TreeNode>();
        var queue_val = new LinkedList<Integer>();
        queue_root.offer(root);
        queue_val.offer(root.val);

        while (!queue_val.isEmpty()) {
            int size = queue_val.size();

            for (int i = 0; i < size; i++) {
                var node = queue_root.poll();
                int val = queue_val.poll();
                if (val == sum && node.left == null && node.right == null)
                    return true;
                if (node.left != null) {
                    queue_root.offer(node.left);
                    queue_val.offer(val + node.left.val);
                }
                if (node.right != null) {
                    queue_root.offer(node.right);
                    queue_val.offer(val + node.right.val);
                }
            }
        }

        return false;
    }
}