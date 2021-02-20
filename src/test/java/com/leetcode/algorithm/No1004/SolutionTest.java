package com.leetcode.algorithm.No1004;

import org.junit.Test;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    public void longestOnes() {
        int[] test = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(solution.longestOnes(test, 0));
    }
}