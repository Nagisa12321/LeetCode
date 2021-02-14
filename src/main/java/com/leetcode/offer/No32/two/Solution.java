package com.leetcode.offer.No32.two;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/12 9:45
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        var queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            res.add(list);
        }

        return res;
    }
}