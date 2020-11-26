package com.leetcode.algorithm.No739;

/**
 * 双指针遍历
 */
public class Solution2 {
    public int[] dailyTemperatures(int[] T) {
        //左右指针
        int left = 0, right = 0;
        //新建数组保存天数
        int[] theArray = new int[T.length];
        while (left != T.length) {
            while (T[right] <= T[left]) {
                ++right;
                if (right == T.length) {
                    theArray[left] = 0;
                    break;
                }else if (T[right] > T[left])
                    theArray[left] = right - left;
            }
            right = ++left;
        }
        return theArray;
    }
}
