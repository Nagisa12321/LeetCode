package com.leetcode.algorithm;

import com.leetcode.algorithm.No995.Solution;
import org.junit.Test;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    public void minKBitFlips() {
        int[] arr = {0, 0, 0, 1, 0, 1, 1, 0};
        System.out.println(solution.minKBitFlips(arr, 3));
    }
}