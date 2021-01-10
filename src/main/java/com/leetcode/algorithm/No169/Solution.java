package com.leetcode.algorithm.No169;

import java.util.HashMap;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/24 17:45
 * @version 1.0
 ************************************************/
public class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        var map = new HashMap<Integer, Integer>();
        int i = nums.length / 2;
        for (int num : nums) {
            if (map.containsKey(num)) {
                if (map.get(num) == i) return num;
                else map.put(num, map.get(num) + 1);
            } else map.put(num, 1);
        }
        return 0;
    }
}