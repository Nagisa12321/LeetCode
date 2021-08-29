package com.leetcode.algorithm.No647;

/************************************************
 * @description dp[i][j]:s[i][j]是否为回文字串
 * @author jtchen
 * @date 2020/12/5 12:06
 * @version 1.0
 ************************************************/
public class Solution2 {
    public int countSubstrings(String s) {
        s = "%" + s + "#";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int j = s.length() - 2, num = 0;
        while (j >= 1) {
            for (int i = 1; i <= j; i++) {
                dp[i][j] = dp[i - 1][j + 1] || isReverse(s, i, j);
                if (dp[i][j]) num++;
            }
            j--;
        }
        return num;
    }

    public boolean isReverse(String s, int n, int i) {
        for (int j = 0; j <= (i - n) / 2; j++)
            if (s.charAt(n + j) != s.charAt(i - j)) return false;
        return true;
    }
}
