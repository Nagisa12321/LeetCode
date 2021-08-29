package com.leetcode.algorithm.No448;

import java.util.LinkedList;
import java.util.List;

/************************************************
 * @description
 * @author jtchen
 * @date 2020/12/1 13:18
 * @version 1.0
 ************************************************/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new LinkedList<>();
        if (nums.length == 0) return list;
        for (int i = 0; i < nums.length; ++i) {
            int index = nums[i] > 0 ? nums[i] - 1 : -nums[i] - 1;
            nums[index] = nums[index] > 0 ? -nums[index] : nums[index];
        }
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0)
                list.add(i + 1);
        }
        return list;
    }
}
