package com.leetcode.algorithm.No5;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/9 19:30
 */
public class Solution4 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0 || len == 1) return s;
        String result = String.valueOf(s.charAt(0));
        int max = 1;
        // dp[i][j]: s[i]-s[j]�Ƿ�Ϊ�����Ӵ�
        boolean[][] dp = new boolean[len][len];

        // dp[i][i]�϶��ǻ����ִ�
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // ���dp[i][j], ������max�ҳ�result
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                // if (j == i + 1 && s.charAt() )
                // else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1])
                //     dp[i][j] = true;
                if (s.charAt(i) == s.charAt(j) && (j == i + 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }
}
