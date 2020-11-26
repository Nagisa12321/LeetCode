package com.leetcode.algorithm.No217;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> theSet = new HashSet<>();
        for(int i : nums)
            if (!theSet.add(i)) return true;
        return false;
    }
}
