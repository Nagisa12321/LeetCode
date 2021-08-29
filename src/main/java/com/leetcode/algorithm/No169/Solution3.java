package com.leetcode.algorithm.No169;

import java.util.Arrays;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/24 17:58
 * @version 1.0
 ************************************************/
public class Solution3 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}