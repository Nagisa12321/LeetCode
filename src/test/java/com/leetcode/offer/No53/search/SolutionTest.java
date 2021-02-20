package com.leetcode.offer.No53.search;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void search() {
        Solution solution = new Solution();

        int[] test = {5, 7, 7, 8, 8, 10};

        System.out.println(solution.search(test, 8));
    }
}