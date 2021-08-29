package com.leetcode.algorithm.No215;

import java.util.Arrays;

/**
 * @方法 开G使用库函数
 */
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
