package com.leetcode.algorithm.No300;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/12 18:09
 * @version 1.0
 ************************************************/
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1 || nums.length == 0) return nums.length;
        int[] dp = new int[nums.length];
        int max = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int smaller_index = findSmaller(i, nums, dp);
            if (smaller_index == -1) dp[i] = 1;
            else dp[i] = dp[smaller_index] + 1;
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int findSmaller(int index, int[] nums, int[] dp) {
        int maxIndex = -1, max = 0;
        for (int i = index - 1; i >= 0; i--)
            if (nums[i] < nums[index]) {
                if (dp[i] > max) {
                    maxIndex = i;
                    max = dp[i];
                }
            }
        ;
        return maxIndex;
    }
}
