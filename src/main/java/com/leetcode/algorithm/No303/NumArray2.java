package com.leetcode.algorithm.No303;

/************************************************
 * @description dp[i] ��num[0]��num[i] �ĺ�
 * @author jtchen
 * @date 2020/12/6 12:34
 * @version 1.0
 ************************************************/
public class NumArray2 {
    private int[] dp;

    public NumArray2(int[] nums) {
        if (nums.length != 0) {
            dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++)
                dp[i] = dp[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return dp[j];
        return dp[j] - dp[i - 1];
    }
}
