package com.leetcode.algorithm.No152;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/11 15:43
 * @version 1.0
 ************************************************/
public class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0];
        int Max = max;
        for (int i = 1; i < nums.length; i++) {
            int tmp = Math.min(Math.min(max * nums[i], min * nums[i]), nums[i]);
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = tmp;
            Max = Math.max(Max, max);
        }
        return Max;
    }
}
