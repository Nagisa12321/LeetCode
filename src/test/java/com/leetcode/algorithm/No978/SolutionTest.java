package com.leetcode.algorithm.No978;

import org.junit.Test;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void maxTurbulenceSize() {
        // int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};
        // int[] arr = {0, 8, 45, 88, 48, 68, 28, 55, 17, 24};
        // int[] arr = {4, 8, 12, 16};
        int[] arr = {4, 5};
        System.out.println(solution.maxTurbulenceSize(arr));
    }
}