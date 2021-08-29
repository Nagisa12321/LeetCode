package com.leetcode.primary.No9.No6;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/15 0:27
 * @version 1.0
 ************************************************/
public class Solution3 {
    public int missingNumber(int[] nums) {
        int num = 0;
        for (int i = 0; i <= nums.length; i++) num ^= i;
        for (int i : nums) num ^= i;
        return num;
    }
}
