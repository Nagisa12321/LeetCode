package com.leetcode.hashmap.No3.No3;

import java.util.HashSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/6 10:42
 */
public class Solution2 {
    // 用散列表模拟队列
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var set = new HashSet<Integer>();

        if (k >= nums.length) {
            for (int i = 0; i < nums.length; i++)
                if (!set.add(nums[i])) return true;
            return false;
        } else {
            // 先进 k 个元素
            for (int i = 0; i < k; i++)
                if (!set.add(nums[i])) return true;
            // 维持长度为 k 的滑动窗口
            for (int i = 0; i < nums.length - k; i++) {
                if (!set.add(nums[i + k])) return true;
                set.remove(nums[i]);
            }
        }
        return false;
    }
}