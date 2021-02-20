package com.leetcode.offer.No39;

/**
 * 核心理念为 票数正负抵消 。此方法时间和空间复杂度分别为 O(N)O(N) 和 O(1)O(1) ，为本题的最佳解法。
 *
 * @author jtchen
 * @version 1.0
 * @date 2021/2/19 9:53
 */
public class Solution3 {
    public int majorityElement(int[] nums) {
        int x = 0/* 所假设众数下标 */, votes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) x = i;

            if (nums[i] == nums[x]) votes++;
            else votes--;
        }

        return nums[x];
    }
}
