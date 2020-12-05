package com.leetcode.primary.No4.No3;

import java.util.LinkedList;
import java.util.Queue;

/************************************************
 * @description 层序遍历，并且判断是否为回文字符
 * @author jtchen
 * @date 2020/11/26 14:16
 * @version 1.0
 ************************************************/
public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] tmp = new int[size];
            for (int i = 0; i < size; ++i) {
                root = queue.poll();
                tmp[i] = root != null ? root.val : Integer.MIN_VALUE;
                if (root != null) {
                    queue.offer(root.left);
                    queue.offer(root.right);
                }
            }

            for (int i = 0; i < size / 2; ++i) {
                if (tmp[i] != tmp[size - 1 - i]) return false;
            }
        }
        return true;
    }
}
