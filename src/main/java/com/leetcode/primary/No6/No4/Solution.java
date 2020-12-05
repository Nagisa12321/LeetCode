package com.leetcode.primary.No6.No4;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/12/3 14:20
 * @version 1.0
 ************************************************/
public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for(int i = 2;i < nums.length; ++i)
            dp[i] = Math.max(dp[i - 2] + nums[i],dp[i - 1]);
        int max = Integer.MIN_VALUE;
        for(int i : dp) max = Math.max(max,i);
        return max;
    }
}
