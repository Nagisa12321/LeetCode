package com.leetcode.algorithm.No1423;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/19 21:51
 */
public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left = 0, right = k - 1;
        int sum = 0;

        for (int i = left; i <= right; i++) {
            sum += cardPoints[i];
        }

        int max = sum;
        int len = cardPoints.length;
        while (right != len - 1) {
            left = left - 1 < 0 ? len - 1 : left - 1;
            sum += cardPoints[left];
            sum -= cardPoints[right];
            right = right - 1 < 0 ? len - 1 : right - 1;

            max = Math.max(sum, max);
        }

        return max;
    }
}