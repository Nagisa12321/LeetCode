package com.leetcode.offer.No29;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void spiralOrder() {
        int[][] test = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        // int[][] test = {{2, 3}};
        System.out.println(Arrays.toString(solution.spiralOrder(test)));
    }
}