package com.leetcode.offer.No3;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/15 23:54
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        int[] map = new int[nums.length];

        for (int num : nums) {
            if (map[num] != 0) return num;
            map[num]++;
        }

        return 0;
    }
}