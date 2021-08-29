package com.leetcode.recursion.No5.No3;

import com.leetcode.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/17 19:24
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int begin, int last) {
        List<TreeNode> nodeList = new ArrayList<>();

        if (begin == last) {
            nodeList.add(new TreeNode(begin));
            return nodeList;
        }

        for (int i = begin; i <= last; i++) {
            List<TreeNode> leftList;
            List<TreeNode> rightList;
            // 如果i为begin 则它为最左节点
            // 只需拼接右边子树
            if (i == begin) {
                rightList = generateTrees(begin + 1, last);
                for (var rL : rightList) {
                    TreeNode tmp = new TreeNode(i);
                    tmp.right = rL;
                    nodeList.add(tmp);
                }
            }

            // 如果i为last 则它为最右节点
            // 只需拼接左边子树
            else if (i == last) {
                leftList = generateTrees(begin, last - 1);
                for (var lL : leftList) {
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = lL;
                    nodeList.add(tmp);
                }
            } else {
                leftList = generateTrees(begin, i - 1);
                rightList = generateTrees(i + 1, last);
                for (var lL : leftList) {
                    for (var rL : rightList) {
                        TreeNode tmp = new TreeNode(i);
                        tmp.left = lL;
                        tmp.right = rL;
                        nodeList.add(tmp);
                    }
                }
            }

        }
        return nodeList;
    }
}