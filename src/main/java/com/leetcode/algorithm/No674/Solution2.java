package com.leetcode.algorithm.No674;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/25 7:38
 */
public class Solution2 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;

        int dp = 1;
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) dp = 1;
            else dp += 1;

            max = Math.max(max, dp);
        }

        return max;
    }
}