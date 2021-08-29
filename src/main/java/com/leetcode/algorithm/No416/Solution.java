package com.leetcode.algorithm.No416;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/21 13:36
 * @version 1.0
 ************************************************/
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        if (nums.length == 1) return false;
        sum /= 2;
        boolean[][] dp = new boolean[nums.length][sum + 1];
        if (nums[0] <= sum)
            dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == nums[i]) dp[i][j] = true;
                else if (j - nums[i] > 0)
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[nums.length - 1][sum];
    }
}