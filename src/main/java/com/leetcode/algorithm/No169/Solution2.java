package com.leetcode.algorithm.No169;

import java.util.Arrays;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/24 17:54
 * @version 1.0
 ************************************************/
public class Solution2 {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        int j = nums.length / 2;
        Arrays.sort(nums);
        int hand = 1;
        int oldNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == oldNum) {
                if (hand == j) return nums[i];
                else {
                    hand++;
                }
            } else {
                oldNum = nums[i];
                hand = 1;
            }
        }
        return 0;
    }
}