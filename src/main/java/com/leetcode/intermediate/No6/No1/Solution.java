package com.leetcode.intermediate.No6.No1;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/1/29 10:41
 */

// �����ڴ�����, ���ý�����ά����
public class Solution {
    public boolean canJump(int[] nums) {
        boolean[][] can = new boolean[nums.length][nums.length];

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                // �������
                int len = j - i;
                if (nums[i] >= len) can[i][j] = true;
                else if (nums[i] == 0) can[i][j] = false;
                else {
                    for (int k = 1; k <= nums[i]; k++) {
                        if (can[i + k][j]) {
                            can[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        return can[0][nums.length - 1];
    }
}