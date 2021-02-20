package com.leetcode.offer.No57.twosum;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/14 11:09
 */
public class Solution4 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target)
                return new int[]{nums[left], nums[right]};
            else if (nums[left] + nums[right] < target)
                left++;
            else right--;
        }

        return new int[2];
    }
}