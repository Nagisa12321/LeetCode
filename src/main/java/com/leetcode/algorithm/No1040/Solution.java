package com.leetcode.algorithm.No1040;

import java.util.Arrays;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/21 10:23
 */
// 超时
public class Solution {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int len = stones.length;
        int max = stones[len - 1] - stones[0] + 1 - len;
        max -= Math.min(stones[len - 1] - stones[len - 2] - 1, stones[1] - stones[0] - 1);

        int min = max;

        for (int i = 0; i < len; i++) {
            int right = stones[i] + len - 1;
            // 计算初始窗口有多少石子
            int idx = i, num = 0;
            while (idx != len && stones[idx] <= right) {
                idx++;
                num++;
            }

            int cost = len - num;
            if (num == len - 1 && stones[idx - 1] - stones[i] + 1 == len - 1)
                cost = 2;

            min = Math.min(cost, min);
        }

        return new int[]{min, max};
    }
}