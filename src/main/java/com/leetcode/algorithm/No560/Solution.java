package com.leetcode.algorithm.No560;

import java.util.HashSet;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/17 13:19
 * @version 1.0
 ************************************************/
public class Solution {
    public int subarraySum(int[] nums, int k) {
        if (k == 0) return 0;
        var set = new HashSet<Integer>();
        int sum = 0, ret = 0;
        for (int num : nums) {
            sum += num;
            set.add(sum);
        }
        if(set.contains(k)) ret++;
        for (int i : set) {
            if (set.contains(k + i)) ret++;
        }
        return ret;
    }
}