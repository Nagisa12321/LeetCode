package com.leetcode.offer.No57;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/14 10:49
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{nums[i], nums[j]};
            }
        }

        return new int[2];
    }
}