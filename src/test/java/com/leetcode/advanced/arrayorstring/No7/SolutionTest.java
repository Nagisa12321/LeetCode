package com.leetcode.advanced.arrayorstring.No7;

import org.junit.Test;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    public void longestConsecutive() {
        int[] test = {1, 2, 0, 1};
        System.out.println(solution.longestConsecutive(test));
    }
}