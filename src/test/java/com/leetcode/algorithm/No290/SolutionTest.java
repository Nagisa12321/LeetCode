package com.leetcode.algorithm.No290;

import static org.junit.Assert.*;

public class SolutionTest {
    public static void main(String[] args) {
        String patten = "abba";
        String s = "cat dog dog cat";
        System.out.println(new Solution().wordPattern(patten, s));
    }
}