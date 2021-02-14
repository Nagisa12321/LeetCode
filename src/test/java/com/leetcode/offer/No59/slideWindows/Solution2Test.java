package com.leetcode.offer.No59.slideWindows;

import java.util.Arrays;

public class Solution2Test {
    public static void main(String[] args) {
        int[] test = {9, 10, 9, -7, -4, -8, 2, -6};

        System.out.println(Arrays.toString(new Solution2().maxSlidingWindow(test, 5)));
    }
}