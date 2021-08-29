package com.leetcode.advanced.arrayorstring.No10;

import java.util.TreeMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/26 9:27
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            // set.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i <= nums.length - k; i++) {
            if (i != 0) {
                // set.remove(nums[i - 1]);
                if (map.get(nums[i - 1]) == 1) map.remove(nums[i - 1]);
                else map.put(nums[i - 1], map.get(nums[i - 1]) - 1);
                // set.add(nums[i + k - 1]);
                map.put(nums[i + k - 1], map.getOrDefault(nums[i + k - 1], 0) + 1);
            }
            // res[i] = set.last();
            res[i] = map.lastKey();
        }
        return res;
    }
}