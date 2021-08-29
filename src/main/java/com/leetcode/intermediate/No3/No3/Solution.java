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
        // 最左节点
        TreeNode left = new TreeNode(preorder[0]);
        // 顶部节点
        TreeNode top = left;
        // 用map存已经加入树的节点
        var map = new HashMap<Integer, TreeNode>();
        map.put(top.val, top);
        // 遍历前序遍历结果, 依次加入树中
        for (int i = 1; i < preorder.length; i++) {
            // 如果是中序遍历首个, 一定要放最左边
            TreeNode node = findLast(preorder[i], inorder, map);
            if (node == null) {
                left.left = new TreeNode(preorder[i]);
                left = left.left;
                // 存入map中
                map.put(preorder[i], left);
            } else findSuccssor(node, preorder[i], map);
        }
        return top;
    }

    /* 寻找某节点的后继节点 */
    public void findSuccssor(TreeNode root, int val, HashMap<Integer, TreeNode> map) {
        // 如果右子树为空, 则说明右边就是后继节点
        if (root.right == null) {
            root.right = new TreeNode(val);
            map.put(val, root.right);
            return;
        }
        // 否则找右子树的最左节点作为后继
        root = root.right;
        while (root.left != null)
            root = root.left;
        root.left = new TreeNode(val);
        map.put(val, root.left);
    }

    /* 通过某个val查找中序遍历中已经存在map中的前一个 */
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