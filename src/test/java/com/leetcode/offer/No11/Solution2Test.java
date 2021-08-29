package com.leetcode.offer.No11;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution2Test {

    @Test
    public void minArray() {
        int[] test = {3, 1, 1};
        Solution2 solution = new Solution2();
        int i = solution.minArray(test);
        System.out.println(i);
    }
}