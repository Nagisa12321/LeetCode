package com.leetcode.offer.No34;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/12 1:19
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (root == null) return res;

        dfs(root, sum, 0, res, list);
        return res;
    }

    public void dfs(TreeNode node, int sum, int num, List<List<Integer>> res, List<Integer> list) {
        // if (node == null || num + node.val > sum) return;
        // else if (num + node.val == sum) {
        //     list.add(node.val);;
        //     res.add(new ArrayList<>(list));
        //     list.clear();
        //     return;
        // }

        if (node == null) return;
        else if (num + node.val == sum) {
            if (node.left == null && node.right == null) {

                list.add(node.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                // list.clear();
                // list.add(top);
                return;
            }
        }

        list.add(node.val);
        num += node.val;

        dfs(node.left, sum, num, res, list);
        dfs(node.right, sum, num, res, list);

        list.remove(list.size() - 1);
    }
}