package com.leetcode.primary.No7.No1;

import java.util.Random;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/14 0:07
 * @version 1.0
 ************************************************/
public class Solution {
    private final int[] reset;
    private final int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
        this.reset = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return reset;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int max = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int index = new Random().nextInt(max)%(max - i + 1) + i;
            int tmp = nums[i];
            nums[i] = nums[index];
            nums[index] = tmp;
        }
        return nums;
    }
}
