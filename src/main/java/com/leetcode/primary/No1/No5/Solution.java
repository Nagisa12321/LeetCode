package com.leetcode.primary.No1.No5;

import java.util.ArrayList;

/**
 * @无脑解法 ： 用ArrayList
 */
public class Solution {
    public int singleNumber(int[] nums) {
        ArrayList<Integer> theList = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i)
            if (theList.contains(nums[i])) theList.remove((Object)nums[i]);
            else theList.add(nums[i]);
        return theList.get(0);
    }
}
