package com.leetcode.algorithm.No424;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    private final Solution solution = new Solution();
    @Test
    public void characterReplacement() {
        String s = "ABAA";

        System.out.println(solution.characterReplacement(s, 0));
    }

    @Test
    public void testReserve() {
        char[] chs = {'A', 'B', 'C', 'D'};
        int len = chs.length;
        for (int j = 0; j < chs.length / 2; j++) {
            char tmp = chs[j];
            chs[j] = chs[len - j - 1];
            chs[len - j - 1] = tmp;
        }

        System.out.println(chs);
    }
}