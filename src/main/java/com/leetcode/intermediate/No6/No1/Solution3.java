package com.leetcode.intermediate.No6.No1;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/29 11:14
 */
public class Solution3 {
    public boolean canJump(int[] nums) {
        // 仅判断能否跳过0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && i != nums.length - 1) {
                boolean canJumpZero = false;
                for (int j = 0; j < i; j++) {
                    if (nums[j] > i - j) {
                        canJumpZero = true;
                        break;
                    }
                }
                // 如果跳不过0, 也跳不了后面的
                if (!canJumpZero) return false;
            }
        }

        return true;
    }
}