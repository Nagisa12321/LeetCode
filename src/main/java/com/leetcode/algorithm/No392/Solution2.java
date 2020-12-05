package com.leetcode.algorithm.No392;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/12/4 11:43
 * @version 1.0
 ************************************************/
public class Solution2 {
    public boolean isSubsequence(String s, String t) {
        int m = t.length();
        int[][] dp = new int[m + 1][26];
        for (int i = 0; i < 26; i++) dp[m][i] = m;
        for (int i = m - 1; i >= 0; i--)
            for (int j = 0; j < 26; j++)
                if (t.charAt(i) == j + 'a') dp[i][j] = i;
                else dp[i][j] = dp[i + 1][j];
        int index = 0;//tµÄÏÂ±ê
        for (int i = 0; i < s.length(); i++) {
            if (dp[index][s.charAt(i) - 'a'] == m) return false;
            index = dp[index][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}
