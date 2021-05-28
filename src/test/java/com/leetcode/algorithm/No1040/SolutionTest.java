package com.leetcode.algorithm.No1040;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    public void numMovesStonesII() {
        // int[] stones = {4, 6, 8, 9, 15, 16, 19, 20};
        // int[] stones = {1, 500000000, 1000000000};
        int[] stones = {7, 4, 9};
        int[] ints = solution.numMovesStonesII(stones);
        System.out.println(Arrays.toString(ints));
    }
}