package com.leetcode.offer.No39;

import org.junit.Test;

public class Solution3Test {

    private final Solution3 solution = new Solution3();
    @Test
    public void majorityElement() {
        int[] test = {1, 2, 3, 2, 2, 2, 5, 4, 2};

        System.out.println(solution.majorityElement(test));
    }
}