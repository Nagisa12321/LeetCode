package com.leetcode.algorithm.No724;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/16 14:47
 */
public class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length <= 1) return -1;

        int idx = -1, left = 0, right = 0, sum = 0;
        for (int i : nums) sum += i;
        right = sum - nums[0];
        if (sum - nums[0] == 0) return 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (left == right) return i;
            left += nums[i];
            right -= nums[i + 1];
        }

        if (sum - nums[nums.length - 1] == 0) return nums.length - 1;

        return idx;
    }
}