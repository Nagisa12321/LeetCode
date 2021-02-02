package com.leetcode.intermediate.No5.No4;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/27 9:32
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) return i - 1;
            else if (i == nums.length - 1) {
                return i;
            }
        }
        return 0;
    }
}