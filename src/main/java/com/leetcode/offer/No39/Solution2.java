package com.leetcode.offer.No39;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/19 9:51
 */
public class Solution2 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}