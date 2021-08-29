package com.leetcode.offer.No57.twosum;

import java.util.HashSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/14 11:04
 */
public class Solution3 {
    public int[] twoSum(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            if (set.contains(target - num)) {
                return new int[]{num, target - num};
            }
        }

        return new int[2];
    }
}