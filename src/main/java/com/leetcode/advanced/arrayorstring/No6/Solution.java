package com.leetcode.advanced.arrayorstring.No6;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/24 12:27
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean haveOne = false;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) haveOne = true;
            else if (nums[i] <= 0) nums[i] = 1;
        }

        if (!haveOne) return 1;
        for (int i = 0; i < len; i++) {
            int tmp = Math.abs(nums[i]);
            if (tmp - 1 < len) {
                int num = nums[tmp - 1];
                nums[tmp - 1] = num > 0 ? -num : num;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return len + 1;
    }
}