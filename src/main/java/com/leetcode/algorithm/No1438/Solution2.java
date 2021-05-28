package com.leetcode.algorithm.No1438;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/23 10:27
 */
public class Solution2 {
    public int longestSubarray(int[] nums, int limit) {
        int len = nums.length;
        if (len == 0) return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0, right = 0;

        int max = 1;
        // set.add(nums[0]);
        map.put(nums[0], 1);

        while (true) {
            // while (right != len - 1 && set.last() - set.first() <= limit)
            //     set.add(nums[++right]);
            while (right != len - 1 && map.lastKey() - map.firstKey() <= limit) {
                right++;
                int key = nums[right];
                if (map.containsKey(key)) map.put(key, map.get(key) + 1);
                else map.put(key, 1);
            }
            // if (set.last() - set.first() > limit) max = Math.max(max, right - left);
            // else max = Math.max(max, right - left + 1);
            if (map.lastKey() - map.firstKey() > limit) max = Math.max(max, right - left);
            else max = Math.max(max, right - left + 1);

            if (right == len - 1) break;
            // set.remove(nums[left++]);
            // set.add(nums[++right]);
            int key_left = nums[left];
            int val_left = map.get(key_left);
            if (val_left == 1) map.remove(key_left);
            else map.put(key_left, val_left - 1);

            left++;
            right++;

            int key = nums[right];
            if (map.containsKey(key)) map.put(key, map.get(key) + 1);
            else map.put(key, 1);
        }
        return max;
    }
}