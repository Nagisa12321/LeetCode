package com.leetcode.advanced.arrayorstring.No8;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution2Test {

    private final Solution solution = new Solution2();

    @Test
    public void findDuplicate() {
        int[] test = {3, 1, 3, 4 ,2};
        System.out.println(solution.findDuplicate(test));
    }
}