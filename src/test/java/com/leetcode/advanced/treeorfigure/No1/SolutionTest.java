package com.leetcode.advanced.treeorfigure.No1;

import com.leetcode.advanced.treeorfigure.No2.Solution;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void solve() {
//        char[][] board = {
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}
//        };

//        char[][] board = {
//                {'X', 'O', 'X'},
//                {'O', 'X', 'O'},
//                {'X', 'O', 'X'}
//        };
//        char[][] board = {
//                {'X', 'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'O', 'X'},
//                {'X', 'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X', 'X'},
//
//        };
//        char[][] board = {
//                {'X', 'X', 'X', 'X', 'O', 'X'},
//                {'O', 'X', 'X', 'O', 'O', 'X'},
//                {'X', 'O', 'X', 'O', 'O', 'O'},
//                {'X', 'O', 'O', 'O', 'X', 'O'},
//                {'O', 'O', 'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'O', 'X', 'X'},
//
//        };
        char[][] board = {
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}

        };
        solution.solve(board);

        System.out.println(Arrays.deepToString(board));
    }
}