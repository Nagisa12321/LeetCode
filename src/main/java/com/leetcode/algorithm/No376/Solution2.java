package com.leetcode.algorithm.No376;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/13 14:03
 * @version 1.0
 ************************************************/
public class Solution2 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dpUp = new int[nums.length];
        int[] dpDown = new int[nums.length];
        dpDown[0] = 1;
        dpUp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dpUp[i] = dpDown[i - 1] + 1;
                dpDown[i] = dpDown[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                dpDown[i] = dpUp[i - 1] + 1;
                dpUp[i] = dpUp[i - 1];
            } else {
                dpDown[i] = dpDown[i - 1];
                dpUp[i] = dpUp[i - 1];
            }
        }
        return Math.max(dpUp[nums.length - 1], dpDown[nums.length - 1]);
    }
}
