package com.leetcode.primary.No9.No6;

import java.util.Arrays;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/15 0:12
 * @version 1.0
 ************************************************/
public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
            if (i != nums[i]) return i;
        return nums.length;
    }
}
