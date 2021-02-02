package com.leetcode.intermediate.No5.No1;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/26 9:11
 */
public class Solution3 {
    public void sortColors(int[] nums) {
        int p0 = 0, p1 = 0;
        // �����0: �Ƚ���, ���p0 < p1 �ٽ��� p0++, p1++
        // �����1: ����, p1++
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = tmp;
                if (p0 < p1) {
                    tmp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = tmp;
                }
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                int tmp = nums[i];
                nums[i] = nums[p1];
                nums[p1++] = tmp;
            }
        }
    }
}