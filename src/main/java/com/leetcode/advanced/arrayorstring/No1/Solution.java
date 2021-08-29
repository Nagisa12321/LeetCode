package com.leetcode.advanced.arrayorstring.No1;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/24 10:10
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len < 2) return new int[len];

        int[] ret = new int[len];
        ret[len - 1] = 1;
        int tmp = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            ret[i] = tmp;
            tmp *= nums[i];
        }

        tmp = 1;
        for (int i = 0; i < len; i++) {
            ret[i] *= tmp;
            tmp *= nums[i];
        }

        return ret;
    }
}