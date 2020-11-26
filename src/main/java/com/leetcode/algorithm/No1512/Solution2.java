package com.leetcode.algorithm.No1512;

/**
 * 用普通数组存试试
 */
public class Solution2 {
    public int numIdenticalPairs(int[] nums) {
        int[] Array = new int[100];
        int i = 0, n = 0;
        while (i!= nums.length) {
            if (Array[nums[i]] >= 1) n += Array[nums[i]];
            Array[nums[i++]]++;
        }
        return n;
    }
}
