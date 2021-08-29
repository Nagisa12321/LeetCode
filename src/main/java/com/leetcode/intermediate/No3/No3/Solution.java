package com.leetcode.intermediate.No3.No3;

import com.leetcode.struct.TreeNode;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/11 15:08
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        // ����ڵ�
        TreeNode left = new TreeNode(preorder[0]);
        // �����ڵ�
        TreeNode top = left;
        // ��map���Ѿ��������Ľڵ�
        var map = new HashMap<Integer, TreeNode>();
        map.put(top.val, top);
        // ����ǰ��������, ���μ�������
        for (int i = 1; i < preorder.length; i++) {
            // �������������׸�, һ��Ҫ�������
            TreeNode node = findLast(preorder[i], inorder, map);
            if (node == null) {
                left.left = new TreeNode(preorder[i]);
                left = left.left;
                // ����map��
                map.put(preorder[i], left);
            } else findSuccssor(node, preorder[i], map);
        }
        return top;
    }

    /* Ѱ��ĳ�ڵ�ĺ�̽ڵ� */
    public void findSuccssor(TreeNode root, int val, HashMap<Integer, TreeNode> map) {
        // ���������Ϊ��, ��˵���ұ߾��Ǻ�̽ڵ�
        if (root.right == null) {
            root.right = new TreeNode(val);
            map.put(val, root.right);
            return;
        }
        // ������������������ڵ���Ϊ���
        root = root.right;
        while (root.left != null)
            root = root.left;
        root.left = new TreeNode(val);
        map.put(val, root.left);
    }

    /* ͨ��ĳ��val��������������Ѿ�����map�е�ǰһ�� */
    public TreeNode findLast(int val, int[] inorder, HashMap<Integer, TreeNode> map) {
        int idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                idx = i;
                break;
            }
        }
        if (idx == 0) return null;
        for (int i = idx; i >= 0; i--) {
            if (map.containsKey(inorder[i]))
                return map.get(inorder[i]);
        }
        return null;
    }
}