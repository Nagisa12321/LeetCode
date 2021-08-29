package com.leetcode.algorithm.No1423;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    public void maxScore() {
        int[] test = {1, 2, 3, 4, 5, 6, 1};

        System.out.println(solution.maxScore(test, 3));
    }
}