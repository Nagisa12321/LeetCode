package com.leetcode.algorithm.No1512; /**
 * 用哈希表存是不是太耗费时间了
 */

import java.util.HashMap;

public class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> theMap = new HashMap<>();
        int index = 0, n = 0;
        while (index != nums.length) {
            if (theMap.containsKey(nums[index])) {
                n += theMap.get(nums[index]);
                theMap.put(nums[index], theMap.get(nums[index++]) + 1);
            } else theMap.put(nums[index++], 1);
        }
        return n;
    }
}
