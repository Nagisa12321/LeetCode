package com.leetcode.offer.No61;

import java.util.HashSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/15 23:45
 */
public class Solution2 {
    public boolean isStraight(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            if (nums[i] != 0) {
                if (!set.add(nums[i])) return false;

                min = Math.min(nums[i], min);
                max = Math.max(nums[i], max);
            }
        }

        return max - min < 5;
    }
}