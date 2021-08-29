package com.leetcode.advanced.arrayorstring.No6;

import org.junit.Test;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void firstMissingPositive() {
        int[] test = {3, 4, -1, -2, 1, 5, 6, 0, 2, 0};

        System.out.println(solution.firstMissingPositive(test));
    }
}