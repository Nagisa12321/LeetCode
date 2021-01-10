package com.leetcode.algorithm.No334;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/10 15:14
 */
public class Solution2 {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= first) first = num;
            else if (num <= second) second = num;
            else return true;
        }
        return false;
    }
}
