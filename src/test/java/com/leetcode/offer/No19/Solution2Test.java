package com.leetcode.offer.No19;

import com.leetcode.offer.No19.Solution2.State;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution2Test {

    private Solution2 solution = new Solution2();
    @Test
    public void buildState() {
        State state = solution.buildState("ab*c");
        System.out.println(state);
    }

    @Test
    public void isMatch() {
        // System.out.println(solution.isMatch("mississippi", "mis*is*ip*."));
        // System.out.println(solution.isMatch("aabc", "c*a*b"));
        // System.out.println(solution.isMatch("ddd", "d*d"));
        // System.out.println(solution.isMatch("aaa", "ab*a*c*a"));
        System.out.println(solution.isMatch("ac", "ab*c"));
    }
}