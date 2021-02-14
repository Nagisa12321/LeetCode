package com.leetcode.offer.No49;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/10 10:58
 */
public class Solution2 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];

        dp[0] = 1;
        int two = 0, three = 0, five = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[two] * 2, Math.min(dp[three] * 3, dp[five] * 5));

            if (dp[two] * 2 == dp[i]) two++;
            if (dp[three] * 3 == dp[i]) three++;
            if (dp[five] * 5 == dp[i]) five++;
        }

        return dp[n - 1];
    }
}
