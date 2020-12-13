package com.leetcode.algorithm.No49;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    public static void main(String[] args) {
        String[] strings = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(Arrays.toString(new Solution().groupAnagrams(strings).toArray()));
    }
}