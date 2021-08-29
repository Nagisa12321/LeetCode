package com.leetcode.algorithm.No1438;

import org.junit.Test;

public class SolutionTest {
    private final Solution2 solution = new Solution2();

    @Test
    public void longestSubarray() {
        int[] test = {10, 1, 2, 4, 7, 2};

        System.out.println(solution.longestSubarray(test, 5));
    }

}