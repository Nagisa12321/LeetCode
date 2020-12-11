package com.leetcode.algorithm.No718;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/10 11:19
 * @version 1.0
 ************************************************/
public class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = dp[i - 1][j - 1] + 1;
                } else dp[i][j] = 0;
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
