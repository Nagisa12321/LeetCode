package com.leetcode.algorithm.No11;

/**
 * 双指针大法：每次都移动最小的那个指针
 */
public class Solution2 {
    public int maxArea(int[] height) {
        int left = 0,right = height.length - 1,max = (right - left) * Math.min(height[left],height[right]);
        while (left != right){
            if (height[left] <= height[right])
                ++left;
            else --right;
            max = Math.max(max,(right - left) * Math.min(height[left],height[right]));
        }
        return max;
    }
}
