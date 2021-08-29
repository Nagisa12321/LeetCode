package com.leetcode.algorithm.No1048;

import java.util.Arrays;
import java.util.Comparator;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/22 20:35
 * @version 1.0
 ************************************************/
public class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[words.length];
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPredecessor(words[i], words[j])) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    res = Math.max(res, dp[j]);
                }
            }
        }
        return res + 1;
    }

    private boolean isPredecessor(String a, String b) {
        int i = 0, j = 0;
        int m = a.length(), n = b.length();
        if ((m + 1) != n) return false;
        while (i < m && j < n) {
            if (a.charAt(i) == b.charAt(j)) i++;
            j++;
        }
        return i == m;
    }

}