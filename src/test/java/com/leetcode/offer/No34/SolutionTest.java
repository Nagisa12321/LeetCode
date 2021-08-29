package com.leetcode.offer.No34;

import com.leetcode.struct.TreeNode;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void pathSum() {

        /*TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;

        n3.left = n5;
        n3.right = n6;

        n4.left = n7;
        n4.right = n8;

        n6.left = n9;
        n6.right = n10;*/

        TreeNode n1 = new TreeNode(-2);
        n1.right = new TreeNode(-3);

        System.out.println(new Solution().pathSum(n1, -5));

    }
}