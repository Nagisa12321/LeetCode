package com.leetcode.interviewQuestions.No8.No1;

/************************************************
 * @description ºÄÊ±40ms ³¬Ô½20
 * @author jtchen
 * @date 2020/12/5 20:57
 * @version 1.0
 ************************************************/
public class Solution {
    public int waysToStep(int n) {
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++)
            dp[i] = ((dp[i - 1] + dp[i - 2]) % 1000000007 + dp[i - 3]) % 1000000007;
        return dp[n];
    }
}
