package com.leetcode.offer.No32.one;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/12 9:41
 */
public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];

        var queue = new LinkedList<TreeNode>();
        var res = new ArrayList<Integer>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        int[] ints = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ints[i] = res.get(i);
        }

        return ints;
    }
}