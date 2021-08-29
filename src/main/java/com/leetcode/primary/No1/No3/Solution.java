package com.leetcode.primary.No1.No3;

/**
 * 用tmp[]数组存放
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] tmp = new int[length];
        for (int i = 0; i < length; ++i)
            tmp[(i + k) % length] = nums[i];
        nums = tmp;
    }
}
