package com.leetcode.offer.No57.findcontinuoussequence;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    private final Solution solution = new Solution();
    @Test
    public void findContinuousSequence() {
        System.out.println(Arrays.deepToString(solution.findContinuousSequence(9)));
    }
}