package com.leetcode.advanced.arrayorstring.No8;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/25 10:26
 */
public class Solution {
    // 不修改数组 nums 的情况下解决这个问题
    // 时间复杂度小于 O(n2) 的解决方案
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int[] map = new int[len - 1];

        for (int num : nums) {
            if (map[num - 1] == 0)
                map[num - 1]++;
            else return num;
        }
        return 0;
    }
}