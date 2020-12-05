package com.leetcode.algorithm.No647;

/************************************************
 * @description dp[i]:第i位回文字串数
 * @author jtchen
 * @date 2020/12/5 11:46
 * @version 1.0
 ************************************************/
public class Solution {
    public int countSubstrings(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            int n = 0;
            for (int j = 0; j <= i; j++)
                if (isReverse(s, j, i)) n++;
            dp[i] = dp[i - 1] + n;
        }
        return dp[s.length() - 1];
    }

    public boolean isReverse(String s, int n, int i) {
        for (int j = 0; j <= (i - n) / 2; j++)
            if (s.charAt(n + j) != s.charAt(i - j)) return false;
        return true;
    }
}
