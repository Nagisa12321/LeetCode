package com.leetcode.offer.No36;

import com.leetcode.struct.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/12 9:56
 */
public class Solution {

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        ArrayList<Node> list = new ArrayList<>();
        inorder(root, list);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i).right = list.get((i + 1) % size);
            list.get((i + 1) % size).left = list.get(i);
        }
        return list.get(0);

    }

    // 遍历获取结果
    public void inorder(Node node, List<Node> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }

}