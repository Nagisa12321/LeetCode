package com.leetcode.algorithm.No338;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/12/8 12:32
 * @version 1.0
 ************************************************/
public class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 1) dp[i] = dp[i - 1] + 1;
            else dp[i] = dp[i / 2];
        }
        return dp;
    }
}
