package com.leetcode.offer.No19;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    public void isMatch() {
        // System.out.println(solution.isMatch("mississippi", "mis*is*ip*."));
        // System.out.println(solution.isMatch("aabc", "c*a*b"));
        // System.out.println(solution.isMatch("ddd", "d*d"));
        // System.out.println(solution.isMatch("aaa", "ab*a*c*a"));
        System.out.println(solution.isMatch("ab", ".*c"));
    }

    @Test
    public void buildBP() {
        solution.buildBP("aa");
    }
}