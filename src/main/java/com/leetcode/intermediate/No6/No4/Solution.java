package com.leetcode.intermediate.No6.No4;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/30 11:05
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            int f = find(nums, i, dp);
            dp[i] = f == -1 ? 1 : dp[f] + 1;
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int find(int[] nums, int i, int[] dp) {
        int idx = -1;
        int max = 0;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                if (dp[j] > max) {
                    max = dp[j];
                    idx = j;
                }
            }
        }

        return idx;
    }
}