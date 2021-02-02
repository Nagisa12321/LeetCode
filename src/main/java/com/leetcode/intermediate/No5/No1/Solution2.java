package com.leetcode.intermediate.No5.No1;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/26 8:46
 */
public class Solution2 {
    public void sortColors(int[] nums) {
        int ptr = 0;
        // 遍历一遍把0放于前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr++] = tmp;
            }
        }
        // 遍历一遍把1放于0后面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr++] = tmp;
            }
        }
    }
}