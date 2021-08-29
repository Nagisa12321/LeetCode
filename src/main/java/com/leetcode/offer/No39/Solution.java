package com.leetcode.offer.No39;

import java.util.HashMap;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/19 9:51
 */
public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int len = nums.length;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int times = map.get(num);
                if (times >= len / 2) return num;
                map.put(num, times + 1);
            } else {
                map.put(num, 1);
            }
        }

        return nums[0];
    }
}