package com.leetcode.hashmap.No3.No3;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/6 10:21
 */
public class Solution {
    // ÆÓËØÏë·¨
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j <= k; j++) {
                if (nums[i] == nums[i + j]) return true;
            }
        }
        return false;
    }
}