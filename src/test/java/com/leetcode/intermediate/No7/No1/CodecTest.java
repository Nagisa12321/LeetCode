package com.leetcode.intermediate.No7.No1;

import com.leetcode.struct.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class CodecTest {

    @Test
    public void serialize() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        /*node4.left = node6;
        node4.right = node7;*/

        System.out.println(new Codec1().serialize(node1));
    }
}