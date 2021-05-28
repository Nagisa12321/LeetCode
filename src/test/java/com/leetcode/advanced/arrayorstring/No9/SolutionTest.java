package com.leetcode.advanced.arrayorstring.No9;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void calculate() {

        // String s = " 3+5 / 2 ";
        String s = "3+2*2";

        System.out.println(solution.calculate(s));

    }
}