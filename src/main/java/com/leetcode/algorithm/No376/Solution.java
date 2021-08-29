package com.leetcode.algorithm.No376;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/12 16:47
 * @version 1.0
 ************************************************/
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1 || nums.length == 0) return nums.length;
        int s = 0, ret = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] && s != 1) {
                ret++;
                s = 1;
            } else if (nums[i] < nums[i - 1] && s != -1) {
                ret++;
                s = -1;
            }
        }
        return ret + 1;
    }
}
