package com.leetcode.primary.No9.No6;

/************************************************
 *
 * @author jtchen
 * @date 2020/12/15 0:12
 * @version 1.0
 ************************************************/
public class Solution2 {
    public int missingNumber(int[] nums) {
        int num = (nums.length + 1) * nums.length / 2;
        for (int i : nums) num -= i;
        return num;
    }
}
