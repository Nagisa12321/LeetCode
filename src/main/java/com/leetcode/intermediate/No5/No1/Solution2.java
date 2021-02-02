package com.leetcode.intermediate.No5.No1;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/26 8:46
 */
public class Solution2 {
    public void sortColors(int[] nums) {
        int ptr = 0;
        // ����һ���0����ǰ��
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr++] = tmp;
            }
        }
        // ����һ���1����0����
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr++] = tmp;
            }
        }
    }
}