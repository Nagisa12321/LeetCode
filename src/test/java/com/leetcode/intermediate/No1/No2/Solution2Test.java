package com.leetcode.intermediate.No1.No2;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution2Test {
    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3, 4},
                {5, 0, 7, 8},
                {0, 10, 11, 12},
                {13, 14, 15, 0}
        };
        new Solution2().setZeroes(m);
        System.out.println(Arrays.deepToString(m));
    }
}