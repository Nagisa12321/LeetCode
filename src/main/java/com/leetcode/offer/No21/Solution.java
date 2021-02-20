package com.leetcode.offer.No21;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/16 22:51
 */
public class Solution {
    public int[] exchange(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                int tmp = nums[idx];
                nums[idx++] = nums[i];
                nums[i] = tmp;
            }
        }
        return nums;
    }
}