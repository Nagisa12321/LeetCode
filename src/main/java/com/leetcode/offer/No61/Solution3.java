package com.leetcode.offer.No61;

import java.util.HashSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/15 23:47
 */
public class Solution3 {
    public boolean isStraight(int[] nums) {
        int[] map = new int[13];

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            if (nums[i] != 0) {
                if (map[nums[i] - 1] != 0) return false;

                map[nums[i] - 1]++;
                min = Math.min(nums[i], min);
                max = Math.max(nums[i], max);
            }
        }

        return max - min < 5;
    }
}
