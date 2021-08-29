package com.leetcode.primary.No1.No3;

/**
 * 通过k把数组分成两部分，分别翻转，最后总的翻转
 */
public class Solution2 {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        nums = reserve(nums, 0, length - k % length - 1);
        nums = reserve(nums, length - k % length, length - 1);
        nums = reserve(nums, 0, length - 1);
    }

    public int[] reserve(int[] nums, int left, int right) {
        if (left >= right) return nums;
        int temp;
        for (int i = 0; i < (right - left) / 2 + 1; ++i) {
            temp = nums[left + i];
            nums[left + i] = nums[right - i];
            nums[right - i] = temp;
        }
        return nums;
    }
}