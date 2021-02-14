package com.leetcode.offer.No46;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/10 9:49
 */
public class Solution {
    public int translateNum(int num) {
        if (num < 10) return 1;
        // 确定num由几位数构成
        int pow = 1;

        if (num == Integer.MAX_VALUE) pow = 10;
        else while (num / (int) Math.pow(10, pow) != 0) pow++;

        int[] dp = new int[pow];
        dp[0] = 1;
        int last = num / (int) Math.pow(10, pow - 1);
        num %= Math.pow(10, pow - 1);

        for (int i = 1; i < pow; i++) {
            int now = num / (int) Math.pow(10, pow - i - 1);

            // dp[i] = dp[i - 1] + ((last * 10 + now) <= 25 ? (i - 2 >= 0 ? dp[i - 2] : 1) : 0);
            dp[i] = last == 0 ? dp[i - 1] : ((last * 10 + now) <= 25 ? dp[i - 1] + (i == 1 ? 1 : dp[i - 2]) : dp[i - 1]);

            last = now;
            num %= (int) Math.pow(10, pow - i - 1);
        }
        return dp[pow - 1];
    }
}