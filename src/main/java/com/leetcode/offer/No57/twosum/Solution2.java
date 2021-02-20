package com.leetcode.offer.No57.twosum;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/14 10:55
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            int num1 = nums[i];

            int lo = i + 1, hi = nums.length - 1;
            while(lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] + num1 == target) return new int[]{num1, nums[mid]};
                else if (nums[mid] + num1 < target) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return new int[2];
    }
}