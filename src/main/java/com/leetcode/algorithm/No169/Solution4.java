package com.leetcode.algorithm.No169;

import java.util.Random;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/24 18:01
 * @version 1.0
 ************************************************/
public class Solution4 {
    public int majorityElement(int[] nums) {
        while (true) {
            int test = nums[new Random().nextInt(nums.length)];
            int count = 0;
            for (int num : nums) {
                if (num == test) ++count;
            }
            if (count >= nums.length / 2) return test;
        }
    }
}