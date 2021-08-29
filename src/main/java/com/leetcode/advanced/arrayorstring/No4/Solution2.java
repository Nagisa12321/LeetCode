package com.leetcode.advanced.arrayorstring.No4;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/2/24 10:25
 */
public class Solution2 {
    public int maxArea(int[] height) {
        int len = height.length;
        if (len < 2) return 0;

        int left = 0, right = len - 1;
        int max = 0;
        while (left < right) {
            // ·ÀÖ¹ÖØ¸´¶Á
            int height_left = height[left];
            int height_right = height[right];

            max = Math.max(max, (right - left) * (Math.min(height_left, height_right)));
            if (height_left < height_right) left++;
            else right--;
        }

        return max;
    }
}