package com.leetcode.algorithm.No303;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/12/6 12:33
 * @version 1.0
 ************************************************/
public class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        while (i <= j)
            sum += nums[i++];
        return sum;
    }
}
