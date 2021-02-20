package com.leetcode.algorithm.No1456;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void maxVowels() {
        String s = "ibpbhixfiouhdljnjfflpapptrxgcomvnb";
        System.out.println(s.length());
        System.out.println(solution.maxVowels(s, 33));
    }
}