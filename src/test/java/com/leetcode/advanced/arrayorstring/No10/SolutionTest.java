package com.leetcode.advanced.arrayorstring.No10;

import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    private final Solution solution = new Solution3();

    @Test
    public void maxSlidingWindow() {
        // int[] test = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] test = {1, -1};

        System.out.println(Arrays.toString(solution.maxSlidingWindow(test, 1)));
    }
}