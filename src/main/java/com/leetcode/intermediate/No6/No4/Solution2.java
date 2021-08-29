package com.leetcode.intermediate.No6.No4;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/30 11:05
 */
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;

        int len = 1;
        int[] dp = new int[nums.length + 1];

        dp[len] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
            } else {
                int lo = 1, hi = len, pos = 0;

                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (dp[mid] < nums[i]) {
                        pos = mid;
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
                dp[pos + 1] = nums[i];
            }
        }

        return len;
    }
}