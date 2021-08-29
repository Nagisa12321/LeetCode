package com.leetcode.offer.No66;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {


    private final Solution2 solution = new Solution2();

    @Test
    public void constructArr() {
        int[] test = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution.constructArr(test)));
    }
}