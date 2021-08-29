package com.leetcode.algorithm.No334;

/**普通dp, 时间复杂度很高！
 * @author jtchen
 * @version 1.0
 * @date 2021/1/10 15:09
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if (dp[i] >= 3) return true;
        }
        return false;
    }
}
