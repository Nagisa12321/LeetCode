package com.leetcode.offer.No32.three;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/12 9:47
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        var queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) return res;

        queue.offer(root);
        int tmp = 1;
        while (!queue.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            if (tmp++ % 2 == 0) {
                for (int i = 0; i < list.size() / 2; i++) {
                    int tmp1 = list.get(i);
                    // list.get(i) = list.get(list.size() - i - 1)
                    list.set(i, list.get(list.size() - i - 1));
                    list.set(list.size() - i - 1, tmp1);
                }
            }

            res.add(list);
        }

        return res;
    }
}
