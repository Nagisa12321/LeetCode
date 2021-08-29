package com.leetcode.advanced.arrayorstring.No4;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/24 10:20
 */
public class Solution {
    public int maxArea(int[] height) {
        int len = height.length;
        if (len < 2) return 0;

        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }

        return max;
    }
}