package com.leetcode.intermediate.No5.No1;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/26 8:33
 */
public class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, two = 0;
        for (int num : nums) {
            if (num == 0)
                zero++;
            else if (num == 1)
                one++;
            else two++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (zero != 0) {
                nums[i] = 0;
                zero--;
            } else if (one != 0) {
                nums[i] = 1;
                one--;
            } else nums[i] = 2;
        }
    }
}