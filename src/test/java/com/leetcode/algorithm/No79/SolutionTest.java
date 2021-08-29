package com.leetcode.algorithm.No79;

import static org.junit.Assert.*;

public class SolutionTest {
    public static void main(String[] args) {
        char[][] board = {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}};

        char[][] board1 = {{'a', 'a'}};
        System.out.println(new Solution().exist(board, "ASADFB"));
    }
}