package com.leetcode.offer.No38;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void permutation() {
        Solution2 solution = new Solution2();

        System.out.println(Arrays.toString(solution.permutation("123")));
    }
}