package com.leetcode.algorithm.No395;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void longestSubstring() {

        String s = "aebabbcfef";
        System.out.println(solution.longestSubstring(s, 2));
    }


}