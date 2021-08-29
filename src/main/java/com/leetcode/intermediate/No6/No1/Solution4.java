package com.leetcode.intermediate.No6.No1;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/29 11:25
 */
public class Solution4 {
    public boolean canJump(int[] nums) {
        // 维护最远可到达位置
        int far = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > far) return false;
            far = Math.max(far, i + nums[i]);
        }
        return true;
    }
}