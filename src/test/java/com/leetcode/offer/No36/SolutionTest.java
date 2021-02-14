package com.leetcode.offer.No36;

import com.leetcode.struct.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void treeToDoublyList() {
        Solution2 solution = new Solution2();

        Node node = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5));

        Node node1 = solution.treeToDoublyList(node);

        // System.out.println(node1);
    }
}