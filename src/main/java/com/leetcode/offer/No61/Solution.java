package com.leetcode.offer.No61;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/15 23:32
 */
public class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);

        // 记录 0 的个数
        int zero = 0;
        for (int num : nums) {
            if (num == 0) zero++;
            else break;
        }

        if (zero == nums.length || zero == nums.length - 1) return true;

        for (int i = zero + 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return false;
            else {
                if (zero >= nums[i] - nums[i - 1] - 1 ) {
                    zero -= nums[i] - nums[i - 1] - 1;
                } else return false;
            }
        }

        return true;
    }
}