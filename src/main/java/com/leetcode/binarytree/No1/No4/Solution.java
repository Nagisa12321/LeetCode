package com.leetcode.binarytree.No1.No4;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/17 14:06
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        var queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            var tmpList = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                var node = queue.poll();
                tmpList.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(tmpList);
        }

        return list;
    }
}