package com.leetcode.algorithm.No1052;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/20 17:43
 */
public class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int num = 0; // 满意顾客数目

        // 前x分钟发功时 满意顾客数
        for (int i = 0; i < len; i++)
            if (i < X || grumpy[i] == 0) num += customers[i];

        int left = 0, right = X - 1;
        int max = num;

        while (right != len - 1) {
            right++;
            if (grumpy[right] == 1) num += customers[right];
            if (grumpy[left] == 1) num -= customers[left];
            left++;

            max = Math.max(max, num);
        }

        return max;
    }
}