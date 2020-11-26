package com.leetcode.algorithm.No84;

/**
 * @思路： 双指针
 */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights,0,newHeights,1,heights.length);
        int theMaxSquare = 0;
        int left = 0, right = 0;
        int wide, height;
        while (left != newHeights.length ) {
            wide = 0;
            height = newHeights[left];
            while (newHeights[left] <= newHeights[right] && right != newHeights.length - 1 ) {
                wide++;
                right++;
            }
            theMaxSquare = Math.max(theMaxSquare, wide * height);
            left++;
            right = left;
        }

        return theMaxSquare;
    }
}
