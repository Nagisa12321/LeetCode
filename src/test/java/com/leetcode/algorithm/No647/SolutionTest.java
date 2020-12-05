package com.leetcode.algorithm.No647;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isReverse() {
        String s = "qabad";
        System.out.println(new Solution().isReverse(s,1,3));
        System.out.println(new Solution().isReverse(s,1,1));
        System.out.println(new Solution().isReverse(s,1,2));
        System.out.println(new Solution().isReverse(s,2,2));
        System.out.println(new Solution().isReverse(s,0,4));
    }

    @Test
    public void countSubstrings() {
        String s = "aaa";
        System.out.println(new Solution().countSubstrings(s));
    }
}