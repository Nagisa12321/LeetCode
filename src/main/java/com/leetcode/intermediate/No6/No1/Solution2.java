package com.leetcode.intermediate.No6.No1;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/29 11:02
 */
public class Solution2 {
    public boolean canJump(int[] nums) {
        // dp[i]能否跳到下标为i的位置
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j] >= i - j) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}