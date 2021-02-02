package com.leetcode.algorithm.No674;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/25 7:38
 */
public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) dp[i] = 1;
            else dp[i] = dp[i - 1] + 1;

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}